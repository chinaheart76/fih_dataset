package com.fih.framework.dataset.utils;

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

}
