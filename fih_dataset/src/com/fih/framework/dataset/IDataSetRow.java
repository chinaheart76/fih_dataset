package com.fih.framework.dataset;

import java.io.Serializable;
import java.util.List;

/**
 * 文件名：IDataSetRow.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午12:28:16<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *
 */

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年3月28日 下午7:04:46  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br> 
 * 数据行接口
 */
public interface IDataSetRow extends Serializable,Iterable<IDataSetDataItem> {
	
	long getId();
	
	/**
	 * 获得数据行中的一个数据项
	 * @param columnName	列名
	 * @return
	 */
	//IDataSetDataItem get(String columnName);
	/**
	 * 获得数据行中的一个数据项
	 * @param columnNo	列序号
	 * @return
	 */
	IDataSetDataItem get(int columnNo);
	IDataSetGetParent<IDataSetRow,IDataSetDataItem> get(int columnNo,boolean b);
	
	/**
	 * 返回数据行中的全部数据项
	 * @return	数据项集合
	 */
	List<IDataSetDataItem> getColumns();
	List<IDataSetDataItem> getColumns(int start,int end);
	List<IDataSetDataItem> getColumns(int[] cols);
	
	/**
	 * 数据行的数据项数量
	 * @return
	 */
	int getColumnCount();
	
	/**
	 * 数据行的状态
	 * @return
	 */
	int getState();
	
	/**
	 * 设置数据行的状态
	 * @param state
	 */
	void setState(int state);
	
	/**
	 * 修改数据行特定的数据项
	 * @param columnName
	 * @param data
	 */
	//void set(String columnName,IDataSetDataItem data);
	IDataSetDataItem set(int columnNo,IDataSetDataItem data);

}

