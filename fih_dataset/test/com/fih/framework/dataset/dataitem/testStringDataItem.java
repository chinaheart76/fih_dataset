package com.fih.framework.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.NullDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.StringDataItem;
import com.fih.framework.dataset.utils.DataItemUtils;

public class testStringDataItem {

	public static void main(String[] args) {
		testStringDataItem testObject = new testStringDataItem();
		
		testObject.testNullDataItem_create();

	}
	
	public void testNullDataItem_create(){
		StringDataItem stringDataItem = new StringDataItem("string data item");
		System.out.println(stringDataItem);
		
		StringDataItem stringDataItem2 = DataItemUtils.buildDataItem("string data item2", DataItemType.STRING);
		System.out.println(stringDataItem2);
		
		stringDataItem.setValue("modify stringDataItem");
		System.out.println(stringDataItem);
		
		stringDataItem.set(stringDataItem2);
		System.out.println(stringDataItem);
		
		stringDataItem.set("modify stringDataItem2");
		System.out.println(stringDataItem);
		
		stringDataItem.setValueString("modify stringDataItem setValueString");
		System.out.println(stringDataItem);
		
	}

}
