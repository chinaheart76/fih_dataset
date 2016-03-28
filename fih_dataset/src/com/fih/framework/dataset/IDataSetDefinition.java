package com.fih.framework.dataset;

import java.util.List;
import java.util.Set;

/**
 * 文件名：IDataSetDefinition.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午7:02:28<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *数据集定义
 */

public interface IDataSetDefinition extends IPropertySet {

	  /**
	   * 数据集定义名
	 * @return
	 */
	String getName();

	  /**
	   * 数据集标题
	 * @return
	 */
	String getCaption();

	  /**
	   * 数据集数据源类型
	 * @return
	 */
	String getDSType();

	/**
	 * 数据集数据源名
	 * @return
	 */
	String getDSName();

	int getType();

	/**
	 * 列序号
	 * @param colName
	 * @return
	 */
	int getColIndex(String colName);

	  /**
	   * 列编号
	 * @param colName
	 * @return
	 */
	int getColNumber(String colName);
	  
	  /**
	   * 列序号对应的列名
	 * @param index
	 * @return
	 */
	String getColName(int index);

	  /**
	   * 列定义集
	 * @return
	 */
	List<IDataSetColumnDefinition> getColumnDefinitions();

	  /**
	   * 数据操作集
	 * @return
	 */
	Set<IDataSetAction> getAllActions();

	  /**
	   * 获得特定操作的操作集
	 * @param actionType
	 * @return
	 */
	IDataSetAction getAction(int actionType);

	  /**
	   * 是否可以插入操作
	 * @return
	 */
	boolean canInsert();

	  /**
	   * 是否可以删除操作
	 * @return
	 */
	boolean canDelete();

	  /**
	   * 是否可以更新操作
	 * @return
	 */
	boolean canUpdate();

	  /**
	   * 是否可以查询操作
	 * @return
	 */
	boolean canQuery();

}

