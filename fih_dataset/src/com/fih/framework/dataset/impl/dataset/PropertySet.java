package com.fih.framework.dataset.impl.dataset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fih.framework.dataset.IPropertySet;
import com.fih.framework.dataset.Property;
import com.fih.framework.dataset.utils.XmlUtils;

public abstract class PropertySet implements IPropertySet {
	
	protected static final JsonFactory jsonFactory = new JsonFactory();

	private static final long serialVersionUID = -4984486545377618050L;
	protected Map<String,Property> properties = new HashMap<String,Property>();

	public PropertySet() {
		super();
	}

	@Override
	public String getPropertyValue(String nameProperty){
		Property property = properties.get(nameProperty);
		if(null == property)
			return "";
		return property.getValue();
	}

	@Override
	public Property getProperty(String propertyName) {
		Property  property = this.properties.get(propertyName);
		property.setName(propertyName);
		
		return property;
	}

	@Override
	public List<Property> getProperties() {
		return (List<Property>) Collections.list((Enumeration<Property>) this.properties.values());
	}

	@Override
	public Property addProperty(Property property) {
		return this.properties.put(property.getName(), property);
	}

	@Override
	public Property addProperty(String name, String value) {
		return this.properties.put(name, new Property(name,value));
	}

	@Override
	public Property removeProperty(String name) {
		return this.properties.remove(name);
	}

	@Override
	public void clear() {
		Property nameProperty = this.properties.get("name");
		this.properties.clear();
		this.properties.put("name", nameProperty);
	}

	@Override
	public int hashCode() {
		return this.properties.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
		      return true;
		    if (!(obj instanceof PropertySet))
		      return false;
		    if (((PropertySet)obj).properties == null)
		      return this.properties == null;
		    return ((PropertySet)obj).properties.equals(this.properties);
	}

	@Override
	public String toString() {
		return "属性集:" + this.properties.toString();
	}

	@Override
	public String setPropertyValue(String name, String value) {
		String oldValue = null;
		if(this.properties.containsKey(name))
			oldValue = getPropertyValue(name);
		this.properties.put(name, new Property(name,value));
		
		return oldValue;
	}
	
	@Override
	public Element toXml() {
		Element el = DocumentFactory.getInstance().createElement("properties");		
		for(Entry<String, Property> property:properties.entrySet()){
			if("name".equals(property.getKey())){
				el.addAttribute("name", property.getValue() == null?"":property.getValue().getValue());
			}else{
				el.add(this.properityToXml(property.getKey(), property.getValue()));
			}
		}
		return el;
	}

	@Override
	public String toJson() {
		ObjectMapper om = new ObjectMapper();
		
		Writer stringWriter = new StringWriter();
		
		try {
			JsonGenerator jsonGen = jsonFactory.createGenerator(stringWriter);
			
			jsonGen.writeStartObject();
					
			String propertiesString = om.writeValueAsString(this.properties);
			jsonGen.writeStringField("properties", propertiesString);
					
			jsonGen.writeEndObject();
			
			jsonGen.close();
			stringWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
				
		return stringWriter.toString();
	}
	
	Element properityToXml(String name ,String value){
		
		Element el = DocumentFactory.getInstance().createElement("property");
		el.addAttribute("name",name);
		el.addAttribute("value",value);
		return el;
	}
	
	Element properityToXml(String name ,Property property){
		
		Element el = DocumentFactory.getInstance().createElement("property");
		el.addAttribute("name",name);
		el.addAttribute("value",property.getValue() == null?"":property.getValue());
		return el;
	}

	@Override
	public void fromXml(Element element) {
		
		String name = element.attributeValue("name");
		this.properties.put("name", new Property("name",name));
		
		List list = element.elements();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Element el = (Element)iterator.next();
			
			if(el.getName().equals("property")){
				this.properties.put(el.attributeValue("name"), new Property(el.attributeValue("name"),el.attributeValue("value")));
			}
			
		}
		
	}

	@Override
	public String toXmlString() {
		return toXml().asXML();
	}

	@Override
	public void fromXml(String xmlString) {
		
		Element el = XmlUtils.createXmlElementFromString(new StringBuffer(xmlString));
		
		fromXml(el);
		
	}

	@Override
	public void fromJson(String json) throws JsonParseException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		StringReader reader = new StringReader(json);
		
		JsonParser jsonP = jsonFactory.createParser(reader);
		
		while(jsonP.nextToken() != JsonToken.END_OBJECT){
			String fieldName = jsonP.getCurrentName();
			if(null == fieldName){
				continue;
			}
			
			if(fieldName.equals("properties")){
				String properties = jsonP.nextTextValue();
				this.properties = om.readValue(properties, HashMap.class);
			}
		
		}
	}
	
}