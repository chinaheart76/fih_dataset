package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class LongDataItem extends AbstractDataItem<Long> {
	
	private static final long serialVersionUID = 4649366698060555378L;
	private long value;
	private long old;

	@Override
	public DataItemType getType() {
		return DataItemType.LONG;
	}

	
	public LongDataItem(long value) {
		super();
		this.value = value;
		this.old = value;
	}

	public LongDataItem(int value) {
		super();
		this.value = value;
		this.old = value;
	}

	public LongDataItem(Long value) {
		super();
		this.value = value.longValue();
		this.old = value.longValue();
	}

	public LongDataItem(Integer value) {
		super();
		this.value = value.longValue();
		this.old = value.longValue();
	}
	
	public LongDataItem(String value){
		super();
		this.value = Long.parseLong(value);
		this.old = Long.parseLong(value);
	}

	@Override
	public void setValue(Long data) {
		this.value = data.longValue();
	}
	
	public void setValue(long data) {
		this.value = data;
	}
	
	public void setValue(Integer data) {
		this.value = data.longValue();
	}
	
	public void setValue(int data) {
		this.value = (long) data;
	}

	/*@Override
	public void set(IDataSetDataItem<Long> data) {
		this.value = data.getValue().longValue();
	}*/

	public void set(LongDataItem data) {
		this.value = data.longValue();
	}

	public void set(IntegerDataItem data) {
		this.value = data.longValue();
	}

	@Override
	public int compareTo(IDataSetDataItem<Long> o) {
		return compareTo(o.getValue().longValue());

	}

	public int compareTo(LongDataItem o) {
		return compareTo(o.longValue());
	}

	public int compareTo(Long o) {
		return compareTo(o.longValue());
	}

	public int compareTo(long o) {
		if(this.value > o)
			return 1;
		if(this.value < o)
			return -1;
		return 0;
	}

	public int compareTo(IntegerDataItem o) {
		return compareTo(o.intValue());
	}

	public int compareTo(Integer o) {
		return compareTo(o.intValue());
	}

	public int compareTo(int o) {
		if(this.value > o)
			return 1;
		if(this.value < o)
			return -1;
		return 0;
	}
	
	public int compareTo(Double o) {
		return compareTo(o.doubleValue());
	}
	
	public int compareTo(double o) {
		if(this.value > o)
			return 1;
		if(this.value < o)
			return -1;
		return 0;
	}
	
	public int compareTo(Float o) {
		return compareTo(o.floatValue());
	}
	
	public int compareTo(float o) {
		if(this.value > o)
			return 1;
		if(this.value < o)
			return -1;
		return 0;
	}

	@Override
	public Long getValue() {
		return this.value;
	}

	public int intValue() {
		return (int) this.value;
	}
	
	public long longValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
	    return (int)(this.value ^ this.value >>> 32);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj instanceof LongDataItem)
			return ((LongDataItem)obj).longValue() == this.value;
		if(obj instanceof IntegerDataItem)
			return ((IntegerDataItem)obj).longValue() == this.value;
		return false;
	}

	@Override
	public String toString() {
		return ""+this.value;
	}
	
	public IntegerDataItem getIntegerDataItem(){
		return new IntegerDataItem(this.value);
	}


	@Override
	public String getValueString() {
		return String.valueOf(this.value);
	}


	@Override
	public void setValueString(String value) {
		this.value = Long.parseLong(value);
	}


	@Override
	public String getOldValueString() {
		return String.valueOf(this.getOldValue());
	}


	/*@Override
	public void setOldValueString(String oldValue) {
		this.setOldValue(Long.parseLong(oldValue));
	}*/


	@Override
	public <D extends IDataSetDataItem<Long>> void set(D data) {
		this.value = data.getValue().longValue();
	}

	@Override
	public Long getOldValue() {
		return this.old;
	}


	@Override
	public boolean isDirty() {
		return this.value != this.old;
	}
}
