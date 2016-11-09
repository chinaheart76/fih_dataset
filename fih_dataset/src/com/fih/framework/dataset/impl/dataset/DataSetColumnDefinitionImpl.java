package com.fih.framework.dataset.impl.dataset;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fih.framework.dataset.IDataSetColumnDefinition;
import com.fih.framework.dataset.Property;
import com.fih.framework.dataset.utils.XmlUtils;

public class DataSetColumnDefinitionImpl extends PropertySet implements IDataSetColumnDefinition {

	private static final long serialVersionUID = -7347907416598531427L;
	private final Map<String,String> codeList = new HashMap<String,String>();
	private static final String [] reservedWords = {"name","alias","caption","type","privateType","length","tableName","tableAlias","isPrimaryKey"};

	@Override
	public String getName() {
		return getPropertyValue("name");
	}

	@Override
	public String getAlias() {
		return getPropertyValue("alias");
	}

	@Override
	public String getCaption() {
		return getPropertyValue("caption");
	}

	@Override
	public int getType() {
		String value = getPropertyValue("type");
		if("".equals(value))
			return 1;
		return Integer.valueOf(value);
	}

	@Override
	public int getPrivateType() {
		String value = getPropertyValue("privateType");
		if("".equals(value))
			return 1;
		return Integer.valueOf(value);
	}

	@Override
	public int getLength() {
		String value = getPropertyValue("length");
		if("".equals(value))
			return 0;
		return Integer.valueOf(value);
	}

	@Override
	public String getTableName() {
		return getPropertyValue("tableName");
	}

	@Override
	public String getTableAlias() {
		return getPropertyValue("tableAlias");
	}
	
	@Override
	public String toString() {
		return this.getName() + ":" + this.properties.toString();
	}

	@Override
	public boolean isPrimaryKey() {
		String value = getPropertyValue("isPrimaryKey");
		if(null == value || "".equals(value.trim()) || "0".equals(value.trim()) || "false".equals(value.trim().toLowerCase())){
			return false;
		}
		
		if("1".equals(value.trim()) || "true".equals(value.trim().toLowerCase())){
			return false;
		}
		
		return false;
	}

	@Override
	public Map<String, String> getCodeList() {
		return this.codeList;
	}

	@Override
	public void setCodeList(Map<String, String> codelist) {
		this.codeList.putAll(codelist);
	}

	@Override
	public void addCodeList(String code, String value) {
		this.codeList.put(code,value);
	}

	@Override
	public void deleteCodeList(String code) {
		this.codeList.remove(code);
	}

	@Override
	public Property removeProperty(String name) {
		for(String reservedWord:reservedWords){
			if(name.equals(reservedWord)){
				return null;
			}
		}
		
		return super.removeProperty(name);
	}

	@Override
	public Element toXml() {
		Element el = super.toXml();
		
		if(!codeList.isEmpty()){
			Element codeListElement = DocumentFactory.getInstance().createElement("codelists");
			for(Entry<String,String> entity:codeList.entrySet()){
				Element code = DocumentFactory.getInstance().createElement("code");
				code.setText(entity.getKey());
				Element value = DocumentFactory.getInstance().createElement("value");
				value.setText(entity.getValue());
				
				Element el2 = DocumentFactory.getInstance().createElement("codelist");
				el2.add(code);
				el2.add(value);
				
				codeListElement.add(el2);
			}
			el.add(codeListElement);
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
					
			String codeListString = om.writeValueAsString(codeList);
			jsonGen.writeStringField("codelist", codeListString);
			
			jsonGen.writeEndObject();
			
			jsonGen.close();
			stringWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
				
		return stringWriter.toString();
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
			
			if(el.getName().equals("codelists")){
				Iterator codelists = el.elements().iterator();
				while(codelists.hasNext()){
					Element codeList = (Element) codelists.next();
					
					Element code = codeList.element("code");
					Element value = codeList.element("value");
					
					this.codeList.put(codeList.element("code").getText(),codeList.element("value").getText());
				}
			}
		}
		
	}
	
	/*@Override
	public void fromXml(String xmlString) {
		Element el = XmlUtils.createXmlElementFromString(new StringBuffer(xmlString));
		
		fromXml(el);
	}*/

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
			
			if(fieldName.equals("codelist")){
				String codelists = jsonP.nextTextValue();
				Map codeList = om.readValue(codelists, HashMap.class);
				this.codeList.putAll(codeList);
			}
		
		}
		
	}

	@Override
	public void clear() {
		this.codeList.clear();
		super.clear();
	}
	
	
	
}
