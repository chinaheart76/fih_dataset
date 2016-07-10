package com.fih.framework.dataset.event;

import java.util.EventListener;

public interface DataSetEventListener<T> extends EventListener {
	
	void before(T t);
	void doEvent(T t);
	void after(T t);

}
