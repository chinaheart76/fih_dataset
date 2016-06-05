package com.fih.framework.dataset.impl.dataset;

import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IStateManager;

public class StateManager implements IStateManager {
	
	private IDataSetDataItem _instance;
	private int state;
	private int oldState;

	public StateManager(IDataSetDataItem _instance) {
		super();
		this._instance = _instance;
	}

	@Override
	public int getState() {
		return this.state;
	}

	@Override
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int getOldState() {
		return this.oldState;
	}

	@Override
	public void setOldState(int state) {
		this.oldState = state;
	}

	@Override
	public boolean isDirty() {
		return this.state != this.oldState;
	}

	@Override
	public void rollbackState() {
		this.state = this.oldState;
	}

	@Override
	public void makeState() {
		// TODO Auto-generated method stub
		
	}

}
