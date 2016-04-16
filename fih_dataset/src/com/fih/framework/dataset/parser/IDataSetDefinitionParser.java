package com.fih.framework.dataset.parser;

import com.fih.framework.dataset.IDataSetDefinition;

public interface IDataSetDefinitionParser {
	
	String marshal(IDataSetDefinition dataSetDefine);
	
	IDataSetDefinition unmarshal(String defineString);

}
