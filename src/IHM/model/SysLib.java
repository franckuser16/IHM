package model;

import java.util.HashMap;

public class SysLib {

	@SuppressWarnings("serial")
	private HashMap<String, String[]> unitList = new HashMap<String, String[]>(){{
		
		put("Area", new String[]{"Metric System","Imperial System"});
		put("Volume", new String[]{"Metric System","Imperial System"});
	}};
	
	public SysLib(){}

	public HashMap<String, String[]> getUnitList() {
		return unitList;
	}

	public void setUnitList(HashMap<String, String[]> unitList) {
		this.unitList = unitList;
	}
}