package com.fih.framework.dataset;

import java.io.Serializable;
import java.util.List;

/**
 * 文件名：IDataSet.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午12:26:38<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *
 */

public interface IDataSet extends Serializable,Iterable<IDataSetRow> {
	
	/**
	 * 数据集名
	 * @return
	 */
	String getName();
	
	/**
	 * 数据集的数据行
	 * @return
	 */
	List<IDataSetRow> getRows();
	List<IDataSetRow> getRows(int start,int end);
	List<IDataSetRow> getRows(int[] rows);
	IDataSetRow getRow(int row);
	IDataSetGetParent<IDataSet,IDataSetRow> getRow(int row,boolean b);
	
	/**
	 * 数据集行数
	 * @return
	 */
	int getRowCount();
	
	int getStartRow();
	int getEndRow();
	int getPageNo();
	
	/**
	 * 数据集特定数据列
	 * @param col
	 * @return
	 */
	IDataSetColumn getColumn(int col);
	IDataSetColumn getColumn(String colName);
	IDataSetGetParent<IDataSet,IDataSetColumn> getColumn(int col,boolean b);
	IDataSetGetParent<IDataSet,IDataSetColumn> getColumn(String colName,boolean b);	
	/**
	 * 数据集多个数据列
	 * @param col
	 * @return
	 */
	List<IDataSetColumn> getColumns(int[] col);
	List<IDataSetColumn> getColumns(String[] colName);

	/**
	 * 数据集列数
	 * @return
	 */
	int getColumnCount();
	
	/**
	 * 数据集定义
	 * @return
	 */
	IDataSetDefinition getDefinition();
	
	
	/**
	 * 获得数据集数据项
	 * @param row
	 * @param col
	 * @return
	 */
	IDataSetDataItem get(int row,int col);
	IDataSetDataItem get(int row,String colName);
	
	/**
	 * 修改数据集数据项
	 * @param row
	 * @param col
	 * @param data
	 */
	IDataSetDataItem set(int row,int col,IDataSetDataItem data);
	IDataSetDataItem set(int row,String colName,IDataSetDataItem data);
	
	/**
	 * 添加数据行
	 * @param row
	 */
	void addRow(IDataSetRow row);
	void addRows(IDataSetRow[] rows);
	void addRows(List<IDataSetRow> rows);

	void addRow(IDataSetDataItem[] columnsDataItem);
	void addRow(List<IDataSetDataItem> columnsDataItem);
		
	/**
	 * 获得数据集
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	IDataSet getDataSet(int startRow,int endRow);
	
	/**
	 * 合并数据集
	 * @param datasets
	 */
	void merge(IDataSet[] datasets);
	void merge(IDataSet datasetSource,IDataSet datasetDest);
	
	void accept(IDataSetVisitor visitor);
	
}

