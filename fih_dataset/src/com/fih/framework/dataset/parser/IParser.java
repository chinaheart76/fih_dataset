package com.fih.framework.dataset.parser;

import com.fih.framework.dataset.IDataSetDefinition;

public interface IParser<T,V> {
	
	T marshal(V v);
	
	V unmarshal(T t);

}
