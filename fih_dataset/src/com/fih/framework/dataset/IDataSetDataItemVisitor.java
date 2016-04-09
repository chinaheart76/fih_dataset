package com.fih.framework.dataset;

public interface IDataSetDataItemVisitor<T> {
	
	void visit(IDataSetDataItem<T> dataItem);

}
