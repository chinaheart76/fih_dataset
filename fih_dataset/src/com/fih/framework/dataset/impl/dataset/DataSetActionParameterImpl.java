package com.fih.framework.dataset.impl.dataset;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fih.framework.dataset.IDataSetActionParameter;
import com.fih.framework.dataset.Property;

public class DataSetActionParameterImpl implements IDataSetActionParameter {

	private static final long serialVersionUID = 3465524141511244570L;
	private Map<String,Property> properties = new HashMap<String,Property>();

	public DataSetActionParameterImpl(String name){
		this.properties.put("name", new Property(String.valueOf(name.hashCode()),name));
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
	public String getName() {
		return this.properties.get("name").getValue();
	}

	@Override
	public void addProperty(Property property) {
		this.properties.put(property.getName(), property);
	}

	@Override
	public void addProperty(String name, String value) {
		this.properties.put(name, new Property(name,value));
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
		    if (!(obj instanceof DataSetActionParameterImpl))
		      return false;
		    if (((DataSetActionParameterImpl)obj).properties == null)
		      return this.properties == null;
		    return ((DataSetActionParameterImpl)obj).properties.equals(this.properties);
	}

	@Override
	public String toString() {
		return this.getName() + ":" + this.properties.toString();
	}

}
