package com.fih.framework.dataset;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.dom4j.Element;

import com.fasterxml.jackson.core.JsonParseException;

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

	String getPropertyValue(String nameProperty);
	Property getProperty(String propertyName);
	
	String setPropertyValue(String name ,String value);
	
	Property addProperty(Property property);
	Property addProperty(String name,String value);
	
	Property removeProperty(String name);
	
	void clear();

	List<Property> getProperties();
	
	Element toXml();
	String toXmlString();
	
	void fromXml(Element element);
	void fromXml(String xmlString);
	
	String toJson();
	
	void fromJson(String json) throws JsonParseException, IOException;
	
}

