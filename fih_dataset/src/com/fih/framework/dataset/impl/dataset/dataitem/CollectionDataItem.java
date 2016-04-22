package com.fih.framework.dataset.impl.dataset.dataitem;

import java.util.List;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

@SuppressWarnings("rawtypes")
public class CollectionDataItem extends AbstractDataItem<List> {

	private static final long serialVersionUID = -2033045237708108505L;
	private List value;

	@Override
	public DataItemType getType() {
		return DataItemType.COLLECTION;
	}

	public CollectionDataItem(List value) {
		super();
		this.value = value;
		this.setOldValue(value);
	}

	@Override
	public List getValue() {
		return this.value;
	}

	@Override
	public void setValue(List data) {
		this.value = data;
	}

	@Override
	public void set(IDataSetDataItem<List> data) {
		this.value = data.getValue();
	}

	public void set(CollectionDataItem data) {
		this.value = data.getValue();
	}

	@Override
	public int compareTo(IDataSetDataItem<List> o) {
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

}
