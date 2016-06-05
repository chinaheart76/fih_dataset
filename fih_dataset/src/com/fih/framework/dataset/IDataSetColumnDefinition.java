package com.fih.framework.dataset;

import java.io.Serializable;

/**
 * 文件名：IDataSetColumnDefinition.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午12:39:52<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *
 */

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年3月28日 下午12:40:48  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br> 
 * 数据集列定义
 */
public interface IDataSetColumnDefinition extends IPropertySet {
	
	  /**
	   * 列名
	 * @return
	 */
	String getName();

	  /**
	   * 列别名
	 * @return
	 */
	String getAlias();
	
	  /**
	   * 列标题
	 * @return
	 */
	String getCaption();
	
	  /**
	   * 列类型
	 * @return
	 */
	int getType();
	
	  /**
	   * 数据库对应类型或者原类型
	 * @return
	 */
	int getPrivateType();
	
	  /**
	   * 列长度
	 * @return
	 */
	int getLength();
	
	  /**
	   * 列所在表名
	 * @return
	 */
	String getTableName();
	
	  /**
	   * 列所在表别名
	 * @return
	 */
	String getTableAlias();
	
	/**
	 * 是否是主键
	 * @return
	 */
	boolean isPrimaryKey();

}

