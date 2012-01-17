package model;

import java.util.HashMap;

public class SysLib {

	@SuppressWarnings("serial")
	private HashMap<Integer, String[]> unitList = new HashMap<Integer, String[]>(){{
		
		put(Dimension.AREA, new String[]{"Metric System","Imperial System"});
		put(Dimension.VOLUME, new String[]{"Metric System","Imperial System"});
	}};
	
	public SysLib(){}

	public HashMap<Integer, String[]> getUnitList() {
		return unitList;
	}

	public void setUnitList(HashMap<Integer, String[]> unitList) {
		this.unitList = unitList;
	}
}