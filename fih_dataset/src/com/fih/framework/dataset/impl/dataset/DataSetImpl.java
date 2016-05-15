package com.fih.framework.dataset.impl.dataset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fih.framework.dataset.IDataSet;
import com.fih.framework.dataset.IDataSetColumn;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IDataSetDefinition;
import com.fih.framework.dataset.IDataSetGetParent;
import com.fih.framework.dataset.IDataSetRow;
import com.fih.framework.dataset.IDataSetVisitor;

public class DataSetImpl implements IDataSet {

	private static final long serialVersionUID = 9074188902520573133L;
	protected IDataSetDefinition define;
	protected List<IDataSetRow> rows;
	private int total =0;
	private volatile boolean changed = false;

	/*private DataSetImpl() {
		super();
	}*/

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
	public IDataSetColumn getColumn(int col) {
		if(col<=0 || col> this.getColumnCount())
			return null;
		
		DataSetColumnImpl column = new DataSetColumnImpl(this.rows.size());
		for(IDataSetRow row:this.rows){
			column.addRow(row.get(col));
		}
		
		return column;
	}

	@Override
	public IDataSetColumn getColumn(String colName) {
		return this.getColumn(this.define.getColIndex(colName));
	}

	@Override
	public List<IDataSetColumn> getColumns(int[] col) {
		if(col == null || col.length == 0)
			return null;
		
		DataSetColumnImpl[] columns = new DataSetColumnImpl[col.length];
		for(IDataSetRow row:this.rows){
			for(int i=0;i<col.length;i++){
				columns[i].addRow(row.get(col[i]));
			}
		}
		
		return Arrays.asList(columns);
	}

	@Override
	public List<IDataSetColumn> getColumns(String[] colName) {
		int[] col = new int[colName.length];
		
		for(int i=0;i<colName.length;i++){
			col[i] = this.define.getColIndex(colName[i]);
		}
		
		return this.getColumns(col);
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
		return this.rows.get(row).get(col);
	}

	@Override
	public IDataSetDataItem get(int row, String colName) {
		return this.get(row, this.define.getColIndex(colName));
	}

	@Override
	public IDataSetDataItem set(int row, int col, IDataSetDataItem data) {
		
		IDataSetDataItem dataItem= this.rows.get(row).set(col, data);
		this.changed = true;
		return dataItem;
	}

	@Override
	public IDataSetDataItem set(int row, String colName, IDataSetDataItem data) {
		return this.set(row, this.define.getColIndex(colName), data);
	}

	@Override
	public void addRow(IDataSetRow row) {
		this.rows.add(row);
	}

	@Override
	public void addRows(IDataSetRow[] rows) {
		for(IDataSetRow row:rows){
			this.rows.add(row);
		}
	}

	@Override
	public void addRows(List<IDataSetRow> rows) {
		this.rows.addAll(rows);
	}

	@Override
	public void addRow(IDataSetDataItem[] columnsDataItem) {
		this.rows.add(new DataSetRowImpl(columnsDataItem));
	}

	@Override
	public void addRow(List<IDataSetDataItem> columnsDataItem) {
		this.rows.add(new DataSetRowImpl(columnsDataItem));
	}

	@Override
	public IDataSet getDataSet(int startRow, int endRow) {
		IDataSet dataSet = new DataSetImpl();
		((DataSetImpl)dataSet).define = this.define;
		for(int i = startRow;i<=endRow;i++){
			((DataSetImpl)dataSet).rows.add(this.rows.get(i));
		}
		((DataSetImpl)dataSet).total = endRow - startRow +1;
		
		return dataSet;
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
		visitor.visit(this);
	}

	@Override
	public IDataSetGetParent<IDataSet,IDataSetRow> getRow(int row,boolean b) {
		return new DataSetGetParentImpl<IDataSet, IDataSetRow>(b?this:null,this.getRow(row));
	}

	@Override
	public IDataSetGetParent<IDataSet,IDataSetColumn> getColumn(int col,boolean b) {
		return new DataSetGetParentImpl<IDataSet, IDataSetColumn>(b?this:null,this.getColumn(col));
	}

	@Override
	public IDataSetGetParent<IDataSet,IDataSetColumn> getColumn(String colName,boolean b) {
		return new DataSetGetParentImpl<IDataSet,IDataSetColumn>(b?this:null,this.getColumn(colName));
	}

}
