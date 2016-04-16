package com.fih.framework.dataset.impl.dataset.dataitem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;

public class DateTimeDataItem extends AbstractDataItem<Date> {

	private static final long serialVersionUID = 313956190329091770L;
	private Date value;

	public DateTimeDataItem(Date value) {
		super();
		this.value = value;
	}

	public DateTimeDataItem(java.sql.Date value) {
		super();
		this.value = value;
	}
	
	public DateTimeDataItem(java.sql.Time value) {
		super();
		this.value = value;
	}

	public DateTimeDataItem(java.sql.Timestamp value) {
		super();
		this.value = value;
	}

	public DateTimeDataItem(String paramString) throws ParseException {
		Date localDate = getDefaultFormat().parse(paramString);
		this.value = localDate;
	}

	@Override
	public DataItemType getType() {
		return DataItemType.DATETIME;
	}

	@Override
	public Date getValue() {
		return this.value;
	}

	@Override
	public void setValue(Date data) {
		this.value = data;
	}

	public void setValue(java.sql.Date data) {
		this.value = data;
	}
	
	public void setValue(java.sql.Time data) {
		this.value = data;
	}

	public void setValue(java.sql.Timestamp data) {
		this.value = data;
	}

	@Override
	public void set(IDataSetDataItem<Date> data) {
		this.value = data.getValue();
	}
	
	public void set(Date data) {
		this.value = data;
	}

	public void set(java.sql.Date data) {
		this.value = data;
	}

	public void set(java.sql.Time data) {
		this.value = data;
	}
	
	public void set(java.sql.Timestamp data){
		this.value = data;
	}

	@Override
	public int compareTo(IDataSetDataItem<Date> o) {
		return this.value.compareTo(o.getValue());
	}
	
	public int compareTo(DateTimeDataItem o) {
		return this.value.compareTo(o.getValue());
	}

	public int compareTo(Date o) {
		return this.value.compareTo(o);
	}
	
	public int compareTo(java.sql.Date o) {
		return this.value.compareTo(o);
	}
	
	public int compareTo(java.sql.Time o) {
		return this.value.compareTo(o);
	}
	
	public int compareTo(java.sql.Timestamp o) {
		return this.value.compareTo(o);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof DateTimeDataItem)
			return this.value.equals(((DateTimeDataItem)obj).getValue());
		return false;
	}

	@Override
	public String toString() {
		if(this.value == null)
			return "";
		if(this.value instanceof Date || this.value instanceof java.sql.Date)
			return "'" + new SimpleDateFormat("yyyy-MM-dd").format(this.value) + "'";
		if(this.value instanceof java.sql.Time || this.value instanceof java.sql.Timestamp)
			return "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.value) + "'";
		return this.value.toString();
	}

	  public static DateFormat getDefaultFormat()
	  {
	    return new SimpleDateFormat("yyyy-MM-dd");
	  }

}
