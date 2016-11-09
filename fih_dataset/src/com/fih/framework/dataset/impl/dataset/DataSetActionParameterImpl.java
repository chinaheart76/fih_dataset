package com.fih.framework.dataset.impl.dataset;

import com.fih.framework.dataset.IDataSetActionParameter;
import com.fih.framework.dataset.Property;

public class DataSetActionParameterImpl extends PropertySet implements IDataSetActionParameter {

	private static final long serialVersionUID = 3465524141511244570L;
	private static final String [] reservedWords = {"name","value","caption"};
	
	public DataSetActionParameterImpl(String name){
		this.properties.put("name", new Property(String.valueOf(name.hashCode()),name));
	}
	
	@Override
	public String toString() {
		return this.getName() + ":" + this.properties.toString();
	}

	@Override
	public String getName() {
		return this.properties.get("name").getValue();
	}

	@Override
	public String getValue() {
		return this.properties.get("value").getValue();
	}

	@Override
	public String getCaption() {
		return this.properties.get("caption").getValue();
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

}
