package com.fih.framework.dataset.impl.dataset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fih.framework.dataset.IDataSetColumn;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IDataSetGetParent;

public class DataSetColumnImpl implements IDataSetColumn {

	private static final long serialVersionUID = 2929794170205772250L;
	private List<IDataSetDataItem> data;
	private final int columnId = 0;

	private DataSetColumnImpl() {
		super();
	}
	
	public DataSetColumnImpl(int rows){
		super();
		this.data = new ArrayList<IDataSetDataItem>(rows);
	}
	
	public DataSetColumnImpl(List<IDataSetDataItem> data){
		super();
		this.data = new ArrayList<IDataSetDataItem>();
		this.data.addAll(data);
	}

	@Override
	public Iterator<IDataSetDataItem> iterator() {
		return this.data.iterator();
	}

	@Override
	public IDataSetDataItem get(int row) {
		return this.data.get(row);
	}

	@Override
	public IDataSetDataItem set(int row, IDataSetDataItem data) {
		return this.data.set(row, data);
	}

	@Override
	public int getRowCount() {
		return this.data.size();
	}

	@Override
	public List<IDataSetDataItem> getAllRows() {
		return this.data;
	}

	@Override
	public List<IDataSetDataItem> getRows(int start, int end) {
		if(this.data == null || this.data.isEmpty())
			return null;
		
		int min = Math.min(start, end);
		if(min == 0)
			min = 1;
		
		if(min > this.data.size())
			return null;
		
		int max = Math.max(start, end);
		if(max == 0)
			return null;
		
		max = Math.min(max, this.data.size());
		
		List<IDataSetDataItem> retList = new ArrayList<IDataSetDataItem>();
		for(int i = min;i<max;i++){
			retList.add(this.data.get(i));
		}
		
		return retList;
	}

	@Override
	public List<IDataSetDataItem> getRows(int[] rows) {
		if(rows == null || rows.length == 0)
			return null;
		if(this.data == null || this.data.isEmpty())
			return null;
		
		List<IDataSetDataItem> retList = new ArrayList<IDataSetDataItem>();
		for(int i:rows){
			if(this.data.size()>i)
				retList.add(this.data.get(i));
		}
		return retList;
	}
	
	public void addRow(IDataSetDataItem row){
		this.data.add(row);
	}

	@Override
	public IDataSetGetParent<IDataSetColumn,IDataSetDataItem> get(int row,boolean b) {
		return new DataSetGetParentImpl<IDataSetColumn,IDataSetDataItem>(b?this:null,this.get(row));
	}

	@Override
	public int getColumnId() {
		return this.columnId;
	}

}
