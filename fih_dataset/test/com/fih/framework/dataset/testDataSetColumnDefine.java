package com.fih.framework.dataset;

import java.io.IOException;

import com.fih.framework.dataset.impl.dataset.DataSetColumnDefinitionImpl;

public class testDataSetColumnDefine {
	
	public static void main(String[] args) {
		testDataSetColumnDefine testObject = new testDataSetColumnDefine();
		
		try {
			testObject.testDataSetColumnDefine_create();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void testDataSetColumnDefine_create() throws IOException{
		
		IDataSetColumnDefinition colDef = new DataSetColumnDefinitionImpl();
		colDef.addProperty("name", "colName");
		colDef.addProperty(new Property("type","varchar2"));
		colDef.addProperty("length", "20");
		colDef.addProperty("alias", "别名");
		colDef.addProperty("caption", "标题");
		colDef.addProperty("tableName", "表名");
		colDef.addProperty("privateType", "私有类型");
		colDef.addProperty("tableAlias", "表别名");
		colDef.addProperty("isPrimaryKey", "false");

		colDef.addProperty("addtion", "附加属性");
		colDef.addProperty("addtion2", "附加属性2");

		colDef.addCodeList("1", "男");
		colDef.addCodeList("2", "女");
		
		String xml = colDef.toXml().asXML();
		String json = colDef.toJson();
		
		System.out.println(colDef);		
		System.out.println(xml);
		System.out.println(json);
		
		colDef.clear();
		
		colDef.fromXml("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+xml);
		
		System.out.println(colDef.toXml().asXML());
		
		colDef.clear();
		
		colDef.fromJson(json);
		
		json = colDef.toJson();
		
		System.out.println(json);
		
	}

}
