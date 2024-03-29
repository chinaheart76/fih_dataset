package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class NullDataItem extends AbstractDataItem<Object> {

	private static final long serialVersionUID = -7269260559965925970L;
	private static NullDataItem a = new NullDataItem();

	public static NullDataItem newInstance() {
		return a;
	}

	private NullDataItem() {
		super();
	}

	@Override
	public String toString() {
		return "null";
	}

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public DataItemType getType() {
		return DataItemType.NULL;
	}

	@Override
	public void setValue(Object data) {

	}

	/*@Override
	public void set(IDataSetDataItem<Object> data) {

	}*/

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NullDataItem;
	}

	@Override
	public int compareTo(IDataSetDataItem<Object> o) {
		if(o.getType() == DataItemType.NULL){
			return 0;
		}
		
		return -1;
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
	public <D extends IDataSetDataItem<Object>> D get() {
		return (D) a;
	}

	@Override
	public <D extends IDataSetDataItem<Object>> void set(D data) {
		
	}

	@Override
	public Object getOldValue() {
		return null;
	}

	@Override
	public boolean isDirty() {
		return false;
	}
	
	

}
