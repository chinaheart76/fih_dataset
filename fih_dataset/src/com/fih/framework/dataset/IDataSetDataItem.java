package com.fih.framework.dataset;

import java.io.Serializable;

/**
 * 文件名：IDataSetData.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午12:33:25<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *
 */

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年3月28日 下午6:19:28  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br> 
 * 数据项接口
 */
public interface IDataSetDataItem<T> extends Serializable,Comparable<IDataSetDataItem<T>> {
	
	
	/**
	 * 数据项类型
	 * @return
	 */
	DataItemType getType();
	/**
	 * 数据项中数据的类型
	 * @return
	 */
	DataItemType getDataType();
	
	/**
	 * 获得数据
	 * @return
	 */
	T getValue();
	/**
	 * 修改数据
	 * @param data
	 */
	void setValue(T data);
	
	/**
	 * 获得数据项接口
	 * @return
	 */
	IDataSetDataItem<T> get();
	/**
	 * 修改数据项接口
	 * @param data
	 */
	void set(IDataSetDataItem<T> data);
	
	/**
	 * 数据项值访问
	 * @param visitor
	 */
	void accept(IDataSetDataItemValueVisitor<T> visitor);
	
	/**
	 * 数据项访问
	 * @param visitor
	 */
	void accept(IDataSetDataItemVisitor<T> visitor);
	
}

