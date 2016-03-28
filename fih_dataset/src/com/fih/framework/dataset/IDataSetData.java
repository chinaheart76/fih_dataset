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
public interface IDataSetData extends Serializable {
	
	
	/**
	 * 数据项类型
	 * @return
	 */
	int getType();
	/**
	 * 数据项中数据的类型
	 * @return
	 */
	int getDataType();
	
	/**
	 * 获得数据
	 * @return
	 */
	Object getValue();
	/**
	 * 修改数据
	 * @param data
	 */
	void setValue(Object data);
	
	/**
	 * 获得数据项接口
	 * @return
	 */
	IDataSetData get();
	/**
	 * 修改数据项接口
	 * @param data
	 */
	void set(IDataSetData data);
	
	/**
	 * 获得数据项状态
	 * @return
	 */
	int getState();
	/**
	 * 修改数据项状态
	 * @param state
	 */
	void setState(int state);
	
	/**
	 * 所在行
	 * @return
	 */
	int getRow();
	/**
	 * 所在列
	 * @return
	 */
	int getColumn();
	/**
	 * 所在列名
	 * @return
	 */
	String getColumnName();

}

