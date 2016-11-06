package com.fih.framework.dataset;

import java.io.Serializable;

import org.dom4j.Element;

/**
 * 文件名：Propery.java<br>
 * 包名 ：com.fih.framework.dataset<br>
 * 创建时间：2016年3月28日 下午6:34:33<br>
 * 最后修改时间：<br>
 * TODO <br>
 * <br>
 *
 */

/**
 * @author 邵福安
 * @version v0.1
 *
 * 创建时间：2016年3月28日 下午6:50:09  <br>
 * 最后修改时间：<br>
 * 		TODO		
 * <br><br> 
 * 属性
 */
public class Property implements Serializable {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -5737187891130849746L;
	private String name;
	private String value;

	public Property() {
		super();
	}

	public Property(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getValue() {
		return value;
	}

	public final void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return (this.name + this.value).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Property)) {
			Property localProperty  = (Property) obj;
			boolean bool1 = (localProperty).name == null ? false
					: this.name == null ? true : localProperty.name.equals(this.name);
			boolean bool2 = localProperty.value == null ? false
					: this.value == null ? true : localProperty.value.equals(this.value);
			return bool1 && bool2;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + ":{" + this.name + '=' + this.value + '}';
	}

}
