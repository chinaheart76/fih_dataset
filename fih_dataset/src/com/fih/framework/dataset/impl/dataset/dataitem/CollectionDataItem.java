package com.fih.framework.dataset.impl.dataset.dataitem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

@SuppressWarnings("rawtypes")
public class CollectionDataItem<T> extends AbstractDataItem<List<T>> {

	private static final long serialVersionUID = -2033045237708108505L;
	private List<T> value = null;
	private List<T> old = null;

	@Override
	public DataItemType getType() {
		return DataItemType.COLLECTION;
	}

	public CollectionDataItem(List<T> value) {
		super();
		this.value =value;
		this.old = Collections.unmodifiableList(value);
	}

	@Override
	public List<T> getValue() {
		return this.value;
	}

	@Override
	public void setValue(List<T> data) {
		this.value = data;
	}

	/*@Override
	public void set(IDataSetDataItem<List<T>> data) {
		this.value = data.getValue();
	}*/

	public void set(CollectionDataItem<T> data) {
		this.value = data.getValue();
	}

	@Override
	public int compareTo(IDataSetDataItem<List<T>> o) {
		return 0;
	}
	
	public int compareTo(CollectionDataItem o) {
		return 0;
	}
	
	public int compareTo(List o) {
		return 0;
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof CollectionDataItem)
			return this.value.equals(((CollectionDataItem)obj).getValue());
		return false;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	@Override
	public String getValueString() {
		return null;
	}

	@Override
	public void setValueString(String value) {
		
	}

	@Override
	public String getOldValueString() {
		return null;
	}

	/*@Override
	public void setOldValueString(String oldValue) {
		
	}*/

	@Override
	public <D extends IDataSetDataItem<List<T>>> void set(D data) {
		this.value = data.getValue();
	}

	@Override
	public List<T> getOldValue() {
		return this.old;
	}

	@Override
	public boolean isDirty() {
		return this.value.equals(this.old);
	}

}
