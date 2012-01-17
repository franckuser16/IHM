package model;

import java.util.HashMap;

public class SysLib {

	private HashMap<Integer, String[]> unitList = new HashMap(){{
		
		put(Dimension.AREA, new String[]{"Metric System","Imperial System"});
		put(Dimension.VOLUME, new String[]{"Metric System","Imperial System"});
	}};
	
	public SysLib(){}
	
	
}