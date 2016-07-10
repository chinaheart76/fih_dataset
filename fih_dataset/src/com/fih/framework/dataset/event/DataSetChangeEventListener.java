package com.fih.framework.dataset.event;

import java.util.EventListener;

public interface DataSetChangeEventListener<T> extends EventListener {
	
	void before(T oldValue);
	void doEvent(T oldValue,T newValue);
	void after(T oldValue,T newValue);

}
