package com.fih.framework.dataset.impl.dataset.dataitem;

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
		this.value = value;
	}

	@Override
	public DataItemType getType() {
		return DataItemType.BYTES;
	}

	@Override
	public byte[] getValue() {
		return this.value;
	}

	@Override
	public void setValue(byte[] data) {
//		this.value = data;
		System.arraycopy(data, 0, this.value, 0, data.length);
	}

	@Override
	public void set(IDataSetDataItem data) {
		// TODO Auto-generated method stub

	}

//	@Override
	public int compareTo(byte[] o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(IDataSetDataItem<byte[]> o) {
	// TODO Auto-generated method stub
	return 0;
	}

	public int compareTo(BinaryDataItem o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof BinaryDataItem))
	      return ((BinaryDataItem)obj).equals(this.value);
	    return false;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

}

