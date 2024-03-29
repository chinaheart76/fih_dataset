package com.fih.framework.dataset.impl.dataset.dataitem;

import java.text.ParseException;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class BooleanDataItem extends AbstractDataItem<Boolean> {

	private static final long serialVersionUID = -5501717206593326570L;
	private boolean value;
	private boolean old;

	public BooleanDataItem(boolean value) {
		super();
		this.value = value;
		this.old = value;
	}
	
	public BooleanDataItem(String value){
		super();
		this.value = Boolean.parseBoolean(value);
		this.old = Boolean.parseBoolean(value);
	}

	@Override
	public DataItemType getType() {
		return DataItemType.BOOLEAN;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public void setValue(Boolean data) {
		this.value = data;
	}

	public void setValue(boolean data) {
		this.value = data;
	}

	/*@Override
	public void set(IDataSetDataItem<Boolean> data) {
		this.value = data.getValue();
	}*/

	public void set(boolean data) {
		this.value = data;
	}

	public void set(Boolean data) {
		this.value = data;
	}

	@Override
	public int compareTo(IDataSetDataItem<Boolean> o) {
		return Boolean.compare(this.value, o.getValue());
	}

	public int compareTo(BooleanDataItem o) {
		return Boolean.compare(this.value, o.getValue());
	}

	public int compareTo(Boolean o) {
		return Boolean.compare(this.value, o);
	}

	public int compareTo(boolean o) {
		return Boolean.compare(this.value, o);
	}

	@Override
	public int hashCode() {
		return Boolean.hashCode(this.value);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof BooleanDataItem)
			return this.value == ((BooleanDataItem)obj).getValue();
		return false;
	}

	@Override
	public String toString() {
		return Boolean.toString(this.value);
	}

	@Override
	public String getValueString() {
		return String.valueOf(this.value);
	}

	@Override
	public void setValueString(String value) {
		this.value = Boolean.parseBoolean(value);
	}

	@Override
	public String getOldValueString() {
		return String.valueOf(this.getOldValue());
	}

	/*@Override
	public void setOldValueString(String oldValue) {
		this.setOldValue(Boolean.parseBoolean(oldValue));
	}*/

	@Override
	public <D extends IDataSetDataItem<Boolean>> void set(D data) {
		this.value = data.getValue();
	}

	@Override
	public Boolean getOldValue() {
		return this.old;
	}

	@Override
	public boolean isDirty() {
		return this.value != this.old;
	}

}
