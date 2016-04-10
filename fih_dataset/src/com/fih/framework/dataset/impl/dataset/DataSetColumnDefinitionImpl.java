package com.fih.framework.dataset.impl.dataset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fih.framework.dataset.IDataSetColumnDefinition;
import com.fih.framework.dataset.Property;

public class DataSetColumnDefinitionImpl extends PropertySet implements IDataSetColumnDefinition {

	private static final long serialVersionUID = -7347907416598531427L;

	@Override
	public String getName() {
		return getPropertyValue("name");
	}

	@Override
	public String getAlias() {
		return getPropertyValue("alias");
	}

	@Override
	public String getCaption() {
		return getPropertyValue("caption");
	}

	@Override
	public int getType() {
		String value = getPropertyValue("type");
		if("".equals(value))
			return 1;
		return Integer.valueOf(value);
	}

	@Override
	public int getPrivateType() {
		String value = getPropertyValue("privateType");
		if("".equals(value))
			return 1;
		return Integer.valueOf(value);
	}

	@Override
	public int getLength() {
		String value = getPropertyValue("length");
		if("".equals(value))
			return 0;
		return Integer.valueOf(value);
	}

	@Override
	public String getTableName() {
		return getPropertyValue("tableName");
	}

	@Override
	public String getTableAlias() {
		return getPropertyValue("tableAlias");
	}
	
	@Override
	public String toString() {
		return this.getName() + ":" + this.properties.toString();
	}
}
