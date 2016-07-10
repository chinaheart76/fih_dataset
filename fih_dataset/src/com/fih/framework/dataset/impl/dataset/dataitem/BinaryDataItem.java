package com.fih.framework.dataset.impl.dataset.dataitem;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

/**
 * 文件名：BinaryDataItem.java<br>
 * 包名     ：com.fih.framework.dataset.impl.dataset.dataitem<br>
 * 创建时间：2016年4月8日 上午9:47:24<br>
 * 最后修改时间：<br>
 * 		TODO
 * <br><br>
 *
 */

public class BinaryDataItem extends AbstractDataItem<byte[]> {

	private static final long serialVersionUID = 141334279286096578L;
	private byte[] value;

	public BinaryDataItem(byte[] value) {
		super();
		this.setValue(value);
		this.setOldValue(value);
	}
	
	public BinaryDataItem(String value){
		super();
		this.setValue(value.getBytes());
		this.setOldValue(value.getBytes());
	}

	@Override
	public DataItemType getType() {
		return DataItemType.BYTES;
	}
	
	public byte[] getOriginValue(){
		return this.value;
	}

	@Override
	public byte[] getValue() {
		byte[] newValue = new byte[this.value.length];
		System.arraycopy(this.value, 0, newValue, 0, this.value.length);
		return newValue;
	}

	@Override
	public void setValue(byte[] data) {
//		System.arraycopy(data, 0, this.value, 0, data.length);
		if(!Arrays.equals(this.value, data)){
			byte[] newValue = new byte[this.value.length];
			System.arraycopy(this.value, 0, newValue, 0, this.value.length);
			
//			this.setOldValue(newValue);
			System.arraycopy(data, 0, this.value, 0, data.length);
//			this.setDirty(true);
		}
	}

	@Override
	public void set(IDataSetDataItem<byte[]> data) {
		if(data instanceof BinaryDataItem){
			this.setValue(((BinaryDataItem)data).getOriginValue());
		}else{
			this.setValue(data.getValue());
		}
	}

	public void set(BinaryDataItem data) {
		this.setValue(data.getOriginValue());
	}

	public int compareTo(byte[] o) {
		if(Arrays.equals(this.value, o))
			return 0;
		return 1;
	}

	@Override
	public int compareTo(IDataSetDataItem<byte[]> o) {
		return compareTo(o.getValue());
	}

	public int compareTo(BinaryDataItem o) {
		return compareTo(o.getOriginValue());
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if ((obj instanceof BinaryDataItem))
	      return Arrays.equals(((BinaryDataItem)obj).getOriginValue(),this.value);
	    return false;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	@Override
	public String getValueString() {
		return String.valueOf(this.value);
	}

	@Override
	public void setValueString(String value) {
		this.value = value.getBytes();
	}

	@Override
	public String getOldValueString() {
		return String.valueOf(this.getOldValue());
	}

	@Override
	public void setOldValueString(String oldValue) {
		this.setOldValue(oldValue.getBytes());
	}

}

