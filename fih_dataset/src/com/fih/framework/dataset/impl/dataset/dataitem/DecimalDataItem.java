package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class DecimalDataItem extends AbstractDataItem<Double> {
	
	private static final long serialVersionUID = 2918776706117784302L;
	private double value;

	
	public DecimalDataItem(int value) {
		super();
		this.value = value;
		this.setOldValue((double) value);
	}

	public DecimalDataItem(long value) {
		super();
		this.value = value;
		this.setOldValue((double) value);
	}
	
	public DecimalDataItem(float value) {
		super();
		this.value = value;
		this.setOldValue((double) value);
	}
	
	public DecimalDataItem(double value) {
		super();
		this.value = value;
		this.setOldValue(value);
	}
	
	public DecimalDataItem(Double value) {
		super();
		this.value = value.doubleValue();
		this.setOldValue(value);
	}
	
	public DecimalDataItem(Long value) {
		super();
		this.value = value.doubleValue();
		this.setOldValue(value.doubleValue());
	}
	
	public DecimalDataItem(Integer value) {
		super();
		this.value = value.doubleValue();
		this.setOldValue(value.doubleValue());
	}
	
	public DecimalDataItem(Float value) {
		super();
		this.value = value.doubleValue();
		this.setOldValue(value.doubleValue());
	}
	
	public DecimalDataItem(String value){
		super();
		this.value = Double.parseDouble(value);
		this.setOldValue(Double.parseDouble(value));
	}
	
	@Override
	public DataItemType getType() {
		return DataItemType.DECIMAL;
	}

	@Override
	public void setValue(Double data) {
		this.value = data.doubleValue();
	}
	
	public void setValue(double data) {
		this.value = data;
	}
	
	public void setValue(Float data) {
		this.value = data.doubleValue();
	}
	
	public void setValue(float data) {
		this.value = data;
	}
	
	public void setValue(Integer data) {
		this.value = data.doubleValue();
	}

	public void setValue(int data) {
		this.value = data;
	}
	
	public void setValue(Long data) {
		this.value = data.doubleValue();
	}
	
	public void setValue(long data) {
		this.value = data;
	}

	@Override
	public void set(IDataSetDataItem<Double> data) {
		this.value = data.getValue().doubleValue();
	}

	public void set(DecimalDataItem data) {
		this.value = data.doubleValue();
	}

	public void set(LongDataItem data) {
		this.value = data.longValue();
	}

	public void set(IntegerDataItem data) {
		this.value = data.intValue();
	}

	@Override
	public int compareTo(IDataSetDataItem<Double> o) {
		return compareTo(o.getValue().doubleValue());
	}

	public int compareTo(DecimalDataItem o) {
		return compareTo(o.doubleValue());
	}
	
	public int compareTo(LongDataItem o) {
		return compareTo(o.longValue());
	}

	public int compareTo(IntegerDataItem o) {
		return compareTo(o.intValue());
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

	@Override
	public Double getValue() {
		return this.value;
	}

	public double doubleValue() {
		return this.value;
	}
	
	@Override
	public int hashCode() {
		long l;
	    return (int)((l = Double.doubleToLongBits(this.value)) ^ l >>> 32);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj instanceof DecimalDataItem)
			return ((DecimalDataItem)obj).doubleValue() == this.value;
		return false;
	}

	@Override
	public String toString() {
		return ""+this.value;
	}

	@Override
	public String getValueString() {
		return String.valueOf(this.value);
	}

	@Override
	public void setValueString(String value) {
		this.value = Double.parseDouble(value);
	}

	@Override
	public String getOldValueString() {
		return String.valueOf(this.getOldValue());
	}

	@Override
	public void setOldValueString(String oldValue) {
		this.setOldValue(Double.parseDouble(oldValue));
	}
	
}
