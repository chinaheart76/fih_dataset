package com.fih.framework.dataset.impl.dataset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IDataSetGetParent;
import com.fih.framework.dataset.IDataSetRow;

public class DataSetRowImpl implements IDataSetRow {

	private static final long serialVersionUID = 2740224877233777291L;
	private List<IDataSetDataItem> data;
	private int state = 0;
	private static long id = 0L;
	
	@Override
	public long getId(){
		return ++id;
	}
	
	private DataSetRowImpl() {
		super();
	}

	public DataSetRowImpl(int cols) {
		super();
		data = new ArrayList<IDataSetDataItem>(cols);
	}
	
	public DataSetRowImpl(IDataSetDataItem[] cols) {
		this(cols.length);
		for(IDataSetDataItem item:cols){
			data.add(item);
		}
	}
	
	public DataSetRowImpl(List<IDataSetDataItem> cols) {
		this(cols.size());
		for(IDataSetDataItem item:cols){
			data.add(item);
		}
	}

	@Override
	public Iterator<IDataSetDataItem> iterator() {
		return this.data.iterator();
	}

	@Override
	public IDataSetDataItem get(int columnNo) {
		return this.data.get(columnNo);
	}

	@Override
	public List<IDataSetDataItem> getColumns() {
		return this.data;
	}

	@Override
	public int getColumnCount() {
		return this.data.size();
	}

	@Override
	public int getState() {
		return this.state;
	}

	@Override
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public IDataSetDataItem set(int columnNo, IDataSetDataItem data) {
		return this.data.set(columnNo, data);
	}

	@Override
	public List<IDataSetDataItem> getColumns(int start, int end) {
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
	public List<IDataSetDataItem> getColumns(int[] cols) {
		if(cols == null || cols.length == 0)
			return null;
		if(this.data == null || this.data.isEmpty())
			return null;
		
		List<IDataSetDataItem> retList = new ArrayList<IDataSetDataItem>();
		for(int i:cols){
			if(this.data.size()>i)
				retList.add(this.data.get(i));
		}
		return retList;
	}

	@Override
	public IDataSetGetParent<IDataSetRow,IDataSetDataItem> get(int columnNo,boolean b) {
		return new DataSetGetParentImpl<IDataSetRow,IDataSetDataItem>(b?this:null,this.get(columnNo));
	}

}
