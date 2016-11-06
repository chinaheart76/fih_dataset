package com.fih.framework.dataset.impl.dataset.dataitem;

import com.fih.framework.dataset.DataItemType;
import com.fih.framework.dataset.IDataSetDataItem;
import com.fih.framework.dataset.IDataSetDataItemValueVisitor;
import com.fih.framework.dataset.IDataSetDataItemVisitor;
import com.fih.framework.dataset.IStateManager;
import com.fih.framework.dataset.impl.dataset.StateManager;

public abstract class AbstractDataItem<T> implements IDataSetDataItem<T> {
	
	private static final long serialVersionUID = 3885597360692560530L;
	
//	private T oldValue;
//	private IStateManager _stateManager = new StateManager(this);
//	private boolean isPrimaryKey = false;
//	private boolean isReadyOnly = false;
//	private boolean isDBINIT = false;
//	private boolean isDirty = false;
	
	@Override
	public DataItemType getDataType() {
		return this.getType();
	}
	
	/*@Override
	public IDataSetDataItem<T> get() {
		return this;
	}*/
	
	@Override
	public <D extends IDataSetDataItem<T>> D get() {
		return (D) this;
	}
	
	public int compareTo(NullDataItem o) {
		return 1;
	}
	
	@Override
	public void accept(IDataSetDataItemValueVisitor<T> visitor){
		visitor.visit(this.getValue());
	}

	@Override
	public void accept(IDataSetDataItemVisitor<T> visitor){
		visitor.visit(this);
	}
	
	/*@Override
	public T getOldValue(){
		return this.oldValue;
	}
	
	
	public void setOldValue(T oldValue) {
		this.oldValue = oldValue;
	}

	@Override
	public boolean isDirty(){
		return !this.get().equals(this.oldValue);
//		return isDirty;
	}*/
	
//	protected void setDirty(boolean b){
//		this.isDirty = b;
//	}
	
//	@Override
//	public boolean isStateDirty(){
//		return this._stateManager.isDirty();
//	}

	/*@Override
	public int getState() {
//		return this._stateManager.getState();
		return 0;
	}

	@Override
	public boolean isNew() {
		return false;
	}

	@Override
	public boolean isDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPersistenceCapable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	@Override
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	@Override
	public boolean isReadyOnly() {
		return isReadyOnly;
	}

	@Override
	public void setReadyOnly(boolean isReadyOnly) {
		this.isReadyOnly = isReadyOnly;
	}

//	public IStateManager get_stateManager() {
//		return _stateManager;
//	}

	@Override
	public boolean isDBINIT() {
		return isDBINIT;
	}

	@Override
	public void setDBINIT(boolean isDBINIT) {
		this.isDBINIT = isDBINIT;
	}*/

}
