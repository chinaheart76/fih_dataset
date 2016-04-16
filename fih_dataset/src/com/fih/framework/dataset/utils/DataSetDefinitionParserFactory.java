package com.fih.framework.dataset.utils;

import com.fih.framework.dataset.parser.IDataSetDefinitionParser;

public class DataSetDefinitionParserFactory {
	
	private static final DataSetDefinitionParserFactory instance = new DataSetDefinitionParserFactory();
	
	private DataSetDefinitionParserFactory(){
		super();
	}
	
	public static DataSetDefinitionParserFactory getInstance(){
		return instance;
	}
	
	public IDataSetDefinitionParser create(){
		return null;
	}
	
}
