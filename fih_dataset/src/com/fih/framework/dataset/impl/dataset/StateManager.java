package com.fih.framework.dataset.impl.dataset;

import java.util.HashMap;
import java.util.Map;

import com.fih.framework.dataset.IStateManager;

public class StateManager implements IStateManager {
	
	public static int STATE_INIT = -1;
	public static int STATE_MODIFY = 1;

//	private IDataSetDataItem _instance;
	private int state = STATE_INIT;
	private int oldState = STATE_INIT;
	private static final Map<Integer,IStateManager> states = new HashMap<Integer,IStateManager>();

//	public StateManager(IDataSetDataItem _instance) {
//		super();
//		this._instance = _instance;
//	}
	
	private StateManager(){
		
	}
	
	private StateManager(int state){
		this.state = this.oldState = state;
	}
	
	public synchronized IStateManager create(int state){
		if(states.containsKey(state)){
			return states.get(states);
		}else{
			IStateManager stateManager = new StateManager(state);
			states.put(state, stateManager);
			
			return stateManager;
		}
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

	/*@Override
	public void makeState() {
		// TODO Auto-generated method stub
		
	}*/

}
