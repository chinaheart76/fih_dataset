package com.fih.framework.dataset;

import java.io.Serializable;

public interface IStateManager extends Serializable {
	
	int getState();
	
	void setState(int state);
	
	int getOldState();
	
	void setOldState(int state);
	
	boolean isDirty();
	
	void rollbackState();
	
//	void makeState();
	
}
