package com.fih.framework.dataset.impl.dataset;

import java.util.ArrayList;
import java.util.List;

import com.fih.framework.dataset.IDataSetAction;
import com.fih.framework.dataset.IDataSetActionParameter;

public class DataSetActionImpl extends PropertySet implements IDataSetAction {

	private static final long serialVersionUID = 5959195515343163553L;
	private List<IDataSetActionParameter> inputArguments = new ArrayList<IDataSetActionParameter>();
	private List<IDataSetActionParameter> outputArguments = new ArrayList<IDataSetActionParameter>();

	@Override
	public String getStatement() {
	    return getPropertyValue("statement");
	}

	@Override
	public int getType() {
		String value = getPropertyValue("type");
		if("".equals(value))
			return 1;
		return Integer.valueOf(value);
	}

	@Override
	public IDataSetActionParameter getInputParameter(int paramInt) {
		return this.inputArguments.get(paramInt);
	}

	@Override
	public List<IDataSetActionParameter> getInputParameters() {
		return this.inputArguments;
	}

	@Override
	public IDataSetActionParameter getOutputParameter(int paramInt) {
		return this.outputArguments.get(paramInt);
	}

	@Override
	public List<IDataSetActionParameter> getOutputParameters() {
		return this.outputArguments;
	}

	@Override
	public void addInputParameter(IDataSetActionParameter parameter) {
		this.inputArguments.add(parameter);
	}

	@Override
	public void addOutputParameter(IDataSetActionParameter parameter) {
		this.outputArguments.add(parameter);
	}

}
