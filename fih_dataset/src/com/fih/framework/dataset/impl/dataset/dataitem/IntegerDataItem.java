package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class IntegerDataItem extends AbstractDataItem<Integer> {
	
	private static final long serialVersionUID = 2918776706117784302L;
	private int value;

	
	public IntegerDataItem(int value) {
		super();
		this.value = value;
	}

	public IntegerDataItem(long value) {
		super();
		this.value = (int) value;
	}
	
	public IntegerDataItem(Integer value) {
		super();
		this.value = value.intValue();
	}
	
	public IntegerDataItem(Long value) {
		super();
		this.value = value.intValue();
	}
	
	@Override
	public DataItemType getType() {
		return DataItemType.INTEGER;
	}

	@Override
	public void setValue(Integer data) {
		this.value = data.intValue();
	}
	
	public void setValue(int data) {
		this.value = data;
	}
	
	public void setValue(Long data) {
		this.value = data.intValue();
	}
	
	public void setValue(long data) {
		this.value = (int) data;
	}

	@Override
	public void set(IDataSetDataItem<Integer> data) {
		this.value = data.getValue().intValue();
	}

	public void set(IntegerDataItem data) {
		this.value = data.intValue();
	}

	public void set(LongDataItem data) {
		this.value = data.intValue();
	}

	@Override
	public int compareTo(IDataSetDataItem<Integer> o) {
		return compareTo(o.getValue().intValue());
	}

	public int compareTo(IntegerDataItem o) {
		return compareTo(o.intValue());
	}
	
	public int compareTo(LongDataItem o) {
		return compareTo(o.longValue());
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
	public Integer getValue() {
		return this.value;
	}

	public int intValue() {
		return this.value;
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
		if(obj instanceof IntegerDataItem)
			return ((IntegerDataItem)obj).intValue() == this.value;
		if(obj instanceof LongDataItem)
			return ((LongDataItem)obj).intValue() == this.value;
		return false;
	}

	@Override
	public String toString() {
		return ""+this.value;
	}
	
	LongDataItem getLongDataItem(){
		return new LongDataItem(this.value);
	}

}