package com.fih.framework.dataset;

import java.io.Serializable;
import java.util.List;

/**
 * 文件名：IPropertySet.java<br>
 * 包名     ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午6:51:26<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *
 */

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年3月28日 下午6:51:40  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br> 
 * 属性集接口
 */
public interface IPropertySet extends Serializable {

	Property getProperty(String paramString);

	List<Property> getProperties();
}

