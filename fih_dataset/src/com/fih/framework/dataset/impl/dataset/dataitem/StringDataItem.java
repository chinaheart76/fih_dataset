package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class StringDataItem extends AbstractDataItem<String> {

	private static final long serialVersionUID = -8927538627640629350L;
	private String value;
	
	public StringDataItem(String value) {
		super();
		this.value = value;
	}

	@Override
	public DataItemType getType() {
		return DataItemType.STRING;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String data) {
		this.value = data;
	}

	@Override
	public void set(IDataSetDataItem<String> data) {
		this.value = data.getValue();
	}

	public void set(StringDataItem data) {
		this.value = data.getValue();
	}

	public void set(String data) {
		this.value = data;
	}

	@Override
	public int compareTo(IDataSetDataItem<String> o) {
		return this.value.compareTo(o.getValue());
	}

	public int compareTo(StringDataItem o) {
		return this.value.compareTo(o.getValue());
	}

	public int compareTo(String o) {
		return this.value.compareTo(o);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof StringDataItem)
			return this.value.equals(((StringDataItem)obj).getValue());
		return false;
	}

	@Override
	public String toString() {
		return this.value;
	}

}
