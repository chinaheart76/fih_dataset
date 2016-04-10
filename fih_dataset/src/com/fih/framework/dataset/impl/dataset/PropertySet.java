package com.fih.framework.dataset.impl.dataset;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fih.framework.dataset.IPropertySet;
import com.fih.framework.dataset.Property;

public class PropertySet implements IPropertySet {

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
		return this.properties.get(propertyName);
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

}