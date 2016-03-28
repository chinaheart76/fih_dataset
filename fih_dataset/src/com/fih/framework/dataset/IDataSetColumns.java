package com.fih.framework.dataset;

import java.io.Serializable;
import java.util.List;

/**
 * 文件名：IDataSetColumn.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午12:28:29<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *数据集的数据列接口
 */

public interface IDataSetColumns extends Serializable {
	
	/**
	 * 获得第几行数据项
	 * @param row
	 * @return
	 */
	IDataSetData get(int row);
	/**
	 * 修改第几行数据项
	 * @param row
	 * @param data
	 */
	void set(int row,IDataSetData data);
	
	/**
	 * 数据列行数
	 * @return
	 */
	int getRowCount();
	
	/**
	 * 获得数据列中全部数据项
	 * @return
	 */
	List<IDataSetData> getAllRows();
	/**
	 * 获得数据列中部分数据项
	 * @param start
	 * @param end
	 * @return
	 */
	List<IDataSetData> getRows(int start,int end);
	

}

