package com.fih.framework.dataset.impl.dataset;

import com.fih.framework.dataset.IDataSetGetParent;

public class DataSetGetParentImpl<T,C> implements IDataSetGetParent<T,C> {
	
	private T parent;
	private C children;

	@Override
	public T getParent() {
		return this.parent;
	}

	public DataSetGetParentImpl(T parent,C children) {
		super();
		this.parent = parent;
		this.children = children;
	}

	@Override
	public C get() {
		return this.children;
	}

}
