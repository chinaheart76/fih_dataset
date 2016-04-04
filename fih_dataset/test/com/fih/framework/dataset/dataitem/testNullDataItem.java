package com.fih.framework.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.NullDataItem;

public class testNullDataItem {

	public static void main(String[] args) {
		testNullDataItem testObject = new testNullDataItem();
		
		testObject.testNullDataItem_create();

	}
	
	public void testNullDataItem_create(){
		//单例模式创造对象
		NullDataItem nullDataItem1 = NullDataItem.newInstance();
		//默认构造函数私有
		//NullDataItem nullDataItem2 = new NullDataItem();
		System.out.println(nullDataItem1);
		
		//数据项类型
		DataItemType dit1 = nullDataItem1.getDataType();
		System.out.println(dit1);
		DataItemType dit2 = nullDataItem1.getType();
		System.out.println(dit2);
		
		NullDataItem nullDataItem3 = (NullDataItem) nullDataItem1.get();
		IDataSetDataItem<Object> nullDataItem4 = nullDataItem1.get();
		Object value1 = nullDataItem1.getValue();

	}

}