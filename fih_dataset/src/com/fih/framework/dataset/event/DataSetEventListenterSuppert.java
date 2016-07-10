package com.fih.framework.dataset.event;

import java.util.EventListener;

public interface DataSetEventListenterSuppert {
	
	void addEventListener(EventListener listener);
	void removeEventListener(EventListener listener);
	void fireEventListener(EventListener listener);
}
