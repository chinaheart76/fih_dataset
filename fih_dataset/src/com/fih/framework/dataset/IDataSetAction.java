package com.fih.framework.dataset;

import java.util.List;

/**
 * 文件名：IDataSetAction.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午6:54:47<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *数据集操作接口
 */

public interface IDataSetAction extends IPropertySet {
	
	  /**
	   * 操作语句
	 * @return
	 */
	String getStatement();

	  /**
	   * 操作类型
	 * @return
	 */
	int getType();

	  /**
	   * 获得输入参数
	 * @param paramInt
	 * @return
	 */
	IDataSetActionParameter getInputParameter(int paramInt);
	
	void addInputParameter(IDataSetActionParameter parameter);

	  /**
	   * 全部输入参数
	 * @return
	 */
	List<IDataSetActionParameter> getInputParameters();

	  /**
	   * 获得输出参数
	 * @param paramInt
	 * @return
	 */
	IDataSetActionParameter getOutputParameter(int paramInt);
	
	void addOutputParameter(IDataSetActionParameter parameter);

	  /**
	   * 获得全部输出参数
	 * @return
	 */
	List<IDataSetActionParameter> getOutputParameters();

}

