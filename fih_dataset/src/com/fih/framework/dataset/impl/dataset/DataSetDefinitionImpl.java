package com.fih.framework.dataset.impl.dataset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.fasterxml.jackson.core.JsonParseException;
import com.fih.framework.dataset.IDataSetAction;
import com.fih.framework.dataset.IDataSetColumnDefinition;
import com.fih.framework.dataset.IDataSetDefinition;

public class DataSetDefinitionImpl extends PropertySet implements IDataSetDefinition {

	private static final long serialVersionUID = 917947270149105375L;
	private Map<Integer,IDataSetAction> actions = new HashMap<Integer,IDataSetAction>(4);
	private List<IDataSetColumnDefinition> columns = new ArrayList<IDataSetColumnDefinition>();
	private Map<Integer,String> colIndexMap = new HashMap<Integer,String>();
	private Map<String,Integer> colNameMap = new HashMap<String,Integer>();

	@Override
	public String getName() {
		return getPropertyValue("name");
	}

	@Override
	public String getCaption() {
		return getPropertyValue("description");
	}

	@Override
	public String getDSType() {
		return getPropertyValue("datasourceType");
	}

	@Override
	public String getDSName() {
		return getPropertyValue("datasourceName");
	}

	@Override
	public int getType() {
		String value = getPropertyValue("type");
		if("".equals(value))
			return -1;
		return Integer.valueOf(value);
	}

	@Override
	public int getColIndex(String colName) {
		return this.colNameMap.get(colName);
	}

	@Override
	public String getColName(int index) {
		return this.colIndexMap.get(index);
	}

	@Override
	public List<IDataSetColumnDefinition> getColumnDefinitions() {
		return this.columns;
	}

	@Override
	public List<IDataSetAction> getAllActions() {
		return (List<IDataSetAction>) this.actions.values();
	}

	@Override
	public IDataSetAction getAction(int actionType) {
		return this.actions.get(actionType);
	}

	@Override
	public boolean canInsert() {
	    return this.actions.containsKey(new Integer(3));
	}

	@Override
	public boolean canDelete() {
	    return this.actions.containsKey(new Integer(4));
	}

	@Override
	public boolean canUpdate() {
	    return this.actions.containsKey(new Integer(2));
	}

	@Override
	public boolean canQuery() {
	    return this.actions.containsKey(new Integer(1));
	}

	@Override
	public final void addColumnDefinition(IDataSetColumnDefinition columnDefinition) {
		int i = this.columns.size();
		String name = null;
		String alias = columnDefinition.getAlias();
		if(null == alias ||"".equals(alias.trim()))
			name = columnDefinition.getName();
		else
			name = alias;
		
		this.columns.add(columnDefinition);
		this.colIndexMap.put(i, name);
		this.colNameMap.put(name, i);
	}

	@Override
	public final IDataSetAction addAction(IDataSetAction action) {
		return this.actions.put(action.getType(), action);
	}

	@Override
	public int hashCode() {
		return super.hashCode()+this.actions.hashCode()+this.columns.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
		      return true;
		    if (!(obj instanceof DataSetDefinitionImpl))
		      return false;
		    boolean bool1 = ((DataSetDefinitionImpl)obj).properties == null ? false : this.properties == null ? true : ((DataSetDefinitionImpl)obj).properties.equals(this.properties);
		    boolean bool2 = ((DataSetDefinitionImpl)obj).columns == null ? false : this.columns == null ? true : ((DataSetDefinitionImpl)obj).columns.equals(this.columns);
		    boolean bool3 = ((DataSetDefinitionImpl)obj).actions == null ? false : this.actions == null ? true : ((DataSetDefinitionImpl)obj).actions.equals(this.actions);
		    return (bool1) && (bool2) && (bool3);
	}

	@Override
	public String toString() {
		return this.getName() + ':' + this.properties.toString() + "\nColumns:" + this.columns.toString() + "\nActions:" + this.actions.toString();
	}
	
	@Override
	public Element toXml(){
		return null;
	}
	
	@Override
	public String toJson(){
		return null;
	}

	@Override
	public void fromXml(Element element) {
		// TODO Auto-generated method stub
		super.fromXml(element);
	}

	@Override
	public void fromJson(String json) throws JsonParseException, IOException {
		// TODO Auto-generated method stub
		super.fromJson(json);
	}
	
	

}
