package com.fih.framework.dataset.impl.dataset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.fasterxml.jackson.core.JsonParseException;
import com.fih.framework.dataset.IDataSetAction;
import com.fih.framework.dataset.IDataSetActionParameter;
import com.fih.framework.dataset.Property;

public class DataSetActionImpl extends PropertySet implements IDataSetAction {

	private static final long serialVersionUID = 5959195515343163553L;
	private final List<IDataSetActionParameter> inputArguments = new ArrayList<IDataSetActionParameter>();
	private final List<IDataSetActionParameter> outputArguments = new ArrayList<IDataSetActionParameter>();
	private static final String [] reservedWords = {"statement","type"};
	
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
	public String getStatement() {
	    return getPropertyValue("statement");
	}

	@Override
	public int getType() {
		String value = getPropertyValue("type");
		if("".equals(value))
			return 1;
		return Integer.valueOf(value);
	}

	@Override
	public IDataSetActionParameter getInputParameter(int paramInt) {
		return this.inputArguments.get(paramInt);
	}

	@Override
	public List<IDataSetActionParameter> getInputParameters() {
		return this.inputArguments;
	}

	@Override
	public IDataSetActionParameter getOutputParameter(int paramInt) {
		return this.outputArguments.get(paramInt);
	}

	@Override
	public List<IDataSetActionParameter> getOutputParameters() {
		return this.outputArguments;
	}

	@Override
	public void addInputParameter(IDataSetActionParameter parameter) {
		this.inputArguments.add(parameter);
	}

	@Override
	public void addOutputParameter(IDataSetActionParameter parameter) {
		this.outputArguments.add(parameter);
	}

	@Override
	public Element toXml() {
		Element el = super.toXml();
		Element statement =DocumentFactory.getInstance().createElement("statement");
		statement.setText(this.getStatement());
		el.add(statement);
		Element type = DocumentFactory.getInstance().createElement("type");
		type.setText(Integer.valueOf(this.getType()).toString());
		el.add(type);
		
		if(!this.inputArguments.isEmpty()){
			Element elementColl = DocumentFactory.getInstance().createElement("inputArguments");
			for(IDataSetActionParameter param:this.inputArguments){
				Element name = DocumentFactory.getInstance().createElement("name");
				name.setText(param.getName());
				Element value = DocumentFactory.getInstance().createElement("value");
				value.setText(param.getValue());
				Element caption = DocumentFactory.getInstance().createElement("caption");
				caption.setText(param.getValue());
				
				Element el2 = DocumentFactory.getInstance().createElement("inputArgument");
				el2.add(name);
				el2.add(value);
				el2.add(caption);
				
				elementColl.add(el2);
			}
			el.add(elementColl);
		}
		
		if(!this.outputArguments.isEmpty()){
			Element elementColl = DocumentFactory.getInstance().createElement("outputArguments");
			for(IDataSetActionParameter param:this.outputArguments){
				Element name = DocumentFactory.getInstance().createElement("name");
				name.setText(param.getName());
				Element value = DocumentFactory.getInstance().createElement("value");
				value.setText(param.getValue());
				Element caption = DocumentFactory.getInstance().createElement("caption");
				caption.setText(param.getValue());
				
				Element el2 = DocumentFactory.getInstance().createElement("outputArgument");
				el2.add(name);
				el2.add(value);
				el2.add(caption);
				
				elementColl.add(el2);
			}
			el.add(elementColl);
		}
		
		return el;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return super.toJson();
	}

	@Override
	public void fromXml(Element element) {
		// TODO Auto-generated method stub
		super.fromXml(element);
	}

	@Override
	public void fromJson(String json) throws JsonParseException, IOException {
		// TODO Auto-generated method stub
		super.fromJson(json);
	}
	
	

}
