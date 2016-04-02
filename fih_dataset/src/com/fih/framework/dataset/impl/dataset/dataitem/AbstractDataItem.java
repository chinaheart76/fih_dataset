package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public abstract class AbstractDataItem<T> implements IDataSetDataItem<T> {
	
	private static final long serialVersionUID = 3885597360692560530L;
	
	@Override
	public DataItemType getDataType() {
		return this.getType();
	}
	
	@Override
	public IDataSetDataItem<T> get() {
		return this;
	}
	
	public int compareTo(NullDataItem o) {
		return 1;
	}

}
