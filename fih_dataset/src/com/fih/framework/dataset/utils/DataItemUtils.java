package com.fih.framework.dataset.utils;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.excpt.DataItemTypeException;
import com.fih.framework.dataset.impl.dataset.dataitem.BooleanDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.DateTimeDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.DecimalDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.IntegerDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.LongDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.NullDataItem;
import com.fih.framework.dataset.impl.dataset.dataitem.StringDataItem;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.Date;

public class DataItemUtils {

	public static IDataSetDataItem buildDataItem(Object paramObject, DataItemType dataItemType)
	  {
	    if (paramObject == null)
	      return NullDataItem.newInstance();
	    
	    switch (dataItemType)
	    {
	    case STRING:
	      return new StringDataItem((String)paramObject);
	    case BOOLEAN:
	      return new BooleanDataItem(((Boolean)paramObject).booleanValue());
	    case INTEGER:
	      return new IntegerDataItem(((Number)paramObject).intValue());
	    case LONG:
		  return new LongDataItem(((Number)paramObject).longValue());
		case DECIMAL:
	      return new DecimalDataItem(((Number)paramObject).doubleValue());
	    case DATETIME:
	      return new DateTimeDataItem((Date)paramObject);
	    }
	    
	    throw new InvalidParameterException(dataItemType.toString());
	  }

	public static IDataSetDataItem buildDataItem(String paramString, DataItemType dataItemType)
	  {
	    if (paramString == null)
	      return NullDataItem.newInstance();
	    
	    switch (dataItemType)
	    {
	    case STRING:
	      return new StringDataItem(paramString);
	    case BOOLEAN:
	      if (paramString.equalsIgnoreCase("false"))
	        return new BooleanDataItem(false);
	      if (paramString.equalsIgnoreCase("true"))
	        return new BooleanDataItem(true);
	      throw new InvalidParameterException(paramString + "Not Boolean");
	    case INTEGER:
	      return new IntegerDataItem(Integer.parseInt(paramString));
	    case LONG:
		  return new LongDataItem(Long.parseLong(paramString));
		case DECIMAL:
	      return new DecimalDataItem(Double.parseDouble(paramString));
	    case DATETIME:
			try {
				return new DateTimeDataItem(paramString);
			} catch (ParseException e) {
				throw new InvalidParameterException("非法的DataItem字符串参数："+paramString);
			}
	    }
	    
	    throw new InvalidParameterException("非法的DataItemType参数："+dataItemType.toString());
	  }
	
	  public static boolean isNumber(DataItemType paramInt)
	  {
	    return (paramInt == DataItemType.INTEGER) || (paramInt == DataItemType.LONG) || (paramInt == DataItemType.DECIMAL);
	  }

	  public static boolean compareType(DataItemType paramInt1, DataItemType paramInt2)
	  {
	    if ((isNumber(paramInt1)) && (isNumber(paramInt2)))
	      return true;
	    return paramInt1 == paramInt2;
	  }

	  public static IDataSetDataItem buildNumberDataValue(double paramDouble)
	  {
	    Double localDouble;
	    if ((localDouble = new Double(paramDouble)).isNaN())
	      return new IntegerDataItem(0);
	    if (localDouble.isInfinite())
	      return new DecimalDataItem(localDouble);
	    if (localDouble.doubleValue() == localDouble.longValue())
	      return new IntegerDataItem(localDouble.longValue());
	    return new DecimalDataItem(localDouble);
	  }

}
