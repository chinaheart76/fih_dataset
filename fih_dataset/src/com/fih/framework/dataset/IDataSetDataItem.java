package com.fih.framework.dataset;

import java.io.Serializable;
import java.text.ParseException;

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
	 * 获得数据项的老值
	 * @return
	 */
	T getOldValue();
	
	/**
	 * 数据项数据是否脏
	 * @return
	 */
	boolean isDirty();
	
	int getState();
	
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
	
	
	/**
	 * 获得字符串形式的值
	 * @return
	 */
	String getValueString();
	
	/**
	 * 设置字符串形式的值
	 * @param value
	 */
	void setValueString(String value);
	
	/**
	 * 获得字符串形式的老值
	 * @return
	 */
	String getOldValueString();
	
	/**
	 * 设置字符串形式的老值
	 * @param oldValue
	 */
	void setOldValueString(String oldValue);
	
	/**
	 * 数据项是否新增
	 * @return
	 */
	boolean isNew();

	/**
	 * 数据项是否删除
	 * @return
	 */
	boolean isDelete();

	/**
	 * 数据项是否更新
	 * @return
	 */
	boolean isUpdate();

	/**
	 * 数据项是否可以持久保持
	 * @return
	 */
	boolean isPersistenceCapable();
	
	/**
	 * 数据项的状态是否脏
	 * @return
	 */
//	boolean isStateDirty();
	void setReadyOnly(boolean isReadyOnly);
	boolean isReadyOnly();
	void setPrimaryKey(boolean isPrimaryKey);
	boolean isPrimaryKey();
	void setDBINIT(boolean isDBINIT);
	boolean isDBINIT();

}

