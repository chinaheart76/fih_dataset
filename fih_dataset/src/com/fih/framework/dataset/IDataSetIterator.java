package com.fih.framework.dataset;

import java.util.Iterator;

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年4月2日 上午10:09:04  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br> 
 * 数据行迭代器
 */
public interface IDataSetIterator extends Iterator<IDataSetRow> {
	
	/**
	 * 移动到第一行
	 */
	void moveFirst();
	
	/**
	 * 移动到最后一行
	 */
	void moveLast();
	
	/**
	 * 移动到指定行
	 * @param row
	 */
	void moveTo(int row);
	
	/**
	 * 前一行
	 * @return
	 */
	IDataSetRow previous();
	
	/**
	 * 获得当前行指定列值
	 * @param column
	 * @return
	 */
	IDataSetDataItem getFieldValue(int column);
	
	/**
	 * 设置当前行指定列的值
	 * @param column
	 * @param value
	 */
	void setFieldValue(int column,IDataSetDataItem value);

}
