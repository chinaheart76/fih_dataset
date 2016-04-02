package com.fih.framework.dataset;

import java.util.Iterator;

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年4月2日 上午10:11:43  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br>
 * 数据项迭代器 
 */
public interface IDataSetDataItemIterator extends Iterator<IDataSetDataItem> {
	
	/**
	 * 移动到第一项
	 */
	void moveFirst();
	
	/**
	 * 移动到最后一项
	 */
	void moveLast();
	
	/**
	 * 移动到指定项
	 * @param row
	 */
	void moveTo(int row);
	
	/**
	 * 前一项
	 * @return
	 */
	IDataSetDataItem previous();

}
