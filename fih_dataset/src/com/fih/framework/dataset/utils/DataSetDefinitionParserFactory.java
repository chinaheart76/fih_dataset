package com.fih.framework.dataset.utils;

import java.io.File;

import com.fih.framework.dataset.IDataSetDefinition;
import com.fih.framework.dataset.impl.dataset.DataSetDefinitionImpl;

public class DataSetDefinitionParserFactory {
	
	private static final DataSetDefinitionParserFactory instance = new DataSetDefinitionParserFactory();
	
	private DataSetDefinitionParserFactory(){
		super();
	}
	
	public static DataSetDefinitionParserFactory getInstance(){
		return instance;
	}
	
	public IDataSetDefinition createDataSetDefinition(){
		return new DataSetDefinitionImpl();
	}
	
	public IDataSetDefinition createDataSetDefineFromSql(String sql){
		return null;
	}
	
	public IDataSetDefinition createDataSetDefineFromXml(String xml){
		return null;
	}
	
	public IDataSetDefinition createDataSetDefineFromJson(String json){
		return null;
	}
	
	public IDataSetDefinition createDataSetDefineFromJpa(Object entity){
		return null;
	}
	
	public File exprotExcel(IDataSetDefinition datasetDefine){
		return null;
	}
	
	public File exprotXmlFile(IDataSetDefinition datasetDefine){
		return null;
	}
	
	public File exprotcvs(IDataSetDefinition datasetDefine){
		return null;
	}
	
	public String exprotJsaon(IDataSetDefinition datasetDefine){
		return null;
	}

	public String exprotXml(IDataSetDefinition datasetDefine){
		return null;
	}
	
}
