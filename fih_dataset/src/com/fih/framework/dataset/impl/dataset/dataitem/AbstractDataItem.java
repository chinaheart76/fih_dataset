package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IDataSetDataItemValueVisitor;
import com.fih.framework.dataset.IDataSetDataItemVisitor;

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
	
	@Override
	public void accept(IDataSetDataItemValueVisitor<T> visitor){
		visitor.visit(this.getValue());
	}

	@Override
	public void accept(IDataSetDataItemVisitor<T> visitor){
		visitor.visit(this);
	}

}
