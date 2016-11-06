package com.fih.framework.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.NullDataItem;
import com.fih.framework.dataset.utils.DataItemUtils;

public class testNullDataItem {

	public static void main(String[] args) {
		testNullDataItem testObject = new testNullDataItem();
		
		testObject.testNullDataItem_create();

	}
	
	public void testNullDataItem_create(){
		//单例模式创造对象
		NullDataItem nullDataItem1 = NullDataItem.newInstance();
		//默认构造函数私有
		NullDataItem nullDataItem2 = DataItemUtils.buildDataItem(null, DataItemType.NULL);
		
		System.out.println(nullDataItem1);
		System.out.println(nullDataItem1);
		
		//数据项类型
		DataItemType dit1 = nullDataItem1.getDataType();
		System.out.println(dit1);
		DataItemType dit2 = nullDataItem1.getType();
		System.out.println(dit2);
		
		NullDataItem nullDataItem3 = nullDataItem1.get();
		IDataSetDataItem<Object> nullDataItem4 = nullDataItem1.get();
		Object value1 = nullDataItem1.getValue();
		if(null == value1){
			System.out.println("空值");
		}
		if(nullDataItem1.equals(nullDataItem3)){
			System.out.println("相等");
		}
		
		if(nullDataItem1.compareTo(nullDataItem4) == 0){
			System.out.println("相等");
		}

	}

}
