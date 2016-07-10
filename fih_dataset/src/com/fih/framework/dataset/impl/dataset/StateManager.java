package com.fih.framework.dataset.impl.dataset;

import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IStateManager;

public class StateManager implements IStateManager {
	
	public static int STATE_INIT = -1;
	public static int STATE_MODIFY = 1;

	private IDataSetDataItem _instance;
	private int state = STATE_INIT;
	private int oldState = STATE_INIT;

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
		this.oldState = this.state;
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
