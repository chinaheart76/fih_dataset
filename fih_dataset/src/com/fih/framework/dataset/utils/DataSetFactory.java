package com.fih.framework.dataset.utils;

import java.io.File;

import com.fih.framework.dataset.IDataSet;
import com.fih.framework.dataset.impl.dataset.DataSetImpl;

public class DataSetFactory {
	
	private static final DataSetFactory instance = new DataSetFactory();
	
	private DataSetFactory(){
		super();
	}
	
	public static DataSetFactory getInstance(){
		return instance;
	}
	
	public IDataSet createDataSet(){
		return new DataSetImpl();
	}
	
	public IDataSet createDataSetFromSql(String sql){
		return null;
	}
	
	public IDataSet createDataSetFromXml(String xml){
		return null;
	}
	
	public IDataSet createDataSetFromJson(String json){
		return null;
	}
	
	public IDataSet createDataSetFromJpa(Object entity){
		return null;
	}
	
	public File exprotExcel(IDataSet dataset){
		return null;
	}
	
	public File exprotXmlFile(IDataSet dataset){
		return null;
	}
	
	public File exprotcvs(IDataSet dataset){
		return null;
	}
	
	public String exprotJsaon(IDataSet dataset){
		return null;
	}

	public String exprotXml(IDataSet dataset){
		return null;
	}
	
	
}
