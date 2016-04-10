package com.fih.framework.dataset.impl.dataset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fih.framework.dataset.IDataSet;
import com.fih.framework.dataset.IDataSetColumns;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IDataSetDefinition;
import com.fih.framework.dataset.IDataSetRow;
import com.fih.framework.dataset.IDataSetVisitor;

public class DataSetImpl implements IDataSet {

	private static final long serialVersionUID = 9074188902520573133L;
	protected IDataSetDefinition define;
	protected List<IDataSetRow> rows;
	private int total;
	private volatile boolean changed = false;

	private DataSetImpl() {
		super();
	}

	@Override
	public Iterator<IDataSetRow> iterator() {
		return this.rows.iterator();
	}

	@Override
	public String getName() {
		return this.define.getName();
	}

	@Override
	public List<IDataSetRow> getRows() {
		return this.rows;
	}

	@Override
	public List<IDataSetRow> getRows(int start, int end) {
		if(this.rows == null || this.rows.isEmpty())
			return null;
		
		int min = Math.min(start, end);
		if(min == 0)
			min = 1;
		
		if(min > this.rows.size())
			return null;
		
		int max = Math.max(start, end);
		if(max == 0)
			return null;
		
		max = Math.min(max, this.rows.size());
		
		List<IDataSetRow> retList = new ArrayList<IDataSetRow>();
		for(int i = min;i<max;i++){
			retList.add(this.rows.get(i));
		}
		
		return retList;
	}

	@Override
	public List<IDataSetRow> getRows(int[] rows) {
		if(rows == null || rows.length == 0)
			return null;
		if(this.rows == null || this.rows.isEmpty())
			return null;
		
		List<IDataSetRow> retList = new ArrayList<IDataSetRow>();
		for(int i:rows){
			if(this.rows.size()>i)
				retList.add(this.rows.get(i));
		}
		
		return retList;
	}
	
	@Override
	public IDataSetRow getRow(int row){
		return this.rows.get(row);
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public IDataSetColumns getColumn(int col) {
		if(col<=0 || col> this.getColumnCount())
			return null;
		
		DataSetColumnsImpl column = new DataSetColumnsImpl(this.rows.size());
		for(IDataSetRow row:this.rows){
			column.addRow(row.get(col));
		}
		
		return column;
	}

	@Override
	public IDataSetColumns getColumn(String colName) {
		return this.getColumn(this.define.getColIndex(colName));
	}

	@Override
	public List<IDataSetColumns> getColumn(int[] col) {
		if(col == null || col.length == 0)
			return null;
		
		return null;
	}

	@Override
	public List<IDataSetColumns> getColumn(String[] colName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		return this.define.getColumnDefinitions().size();
	}

	@Override
	public IDataSetDefinition getDefinition() {
		return this.define;
	}

	@Override
	public IDataSetDataItem get(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDataSetDataItem get(int row, String colName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int row, int col, IDataSetDataItem data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void set(int row, String colName, IDataSetDataItem data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRow(IDataSetRow row) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRows(IDataSetRow[] rows) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRows(List<IDataSetRow> rows) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDataSet getDataSet(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void merge(IDataSet[] datasets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(IDataSet datasetSource, IDataSet datasetDest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(IDataSetVisitor visitor) {
		// TODO Auto-generated method stub

	}

}
