package model;

import java.util.HashMap;

public class UnitFactory {

	private static final String METRIC_SYSTEM_LENGTH = "Metric System Length";
	private static final String METRIC_SYSTEM_VOLUME = "Metric System Volume";
	private static final String IMPERIAL_SYSTEM_LENGTH = "Imperial System Length ";
	private static final String IMPERIAL_SYSTEM_VOLUME = "Imperial System Volume";
	
	@SuppressWarnings("serial")
	private static HashMap<String, String[]> unitList = new HashMap<String, String[]>(){{
		
		put("Length", new String[]{"Metric System","Imperial System"});
		put("Volume", new String[]{"Metric System","Imperial System"});
	}};
	
	public UnitFactory(){}

	public static HashMap<String, String[]> getUnitList() {
		return unitList;
	}

	public void setUnitList(HashMap<String, String[]> unitList) {
		this.unitList = unitList;
	}
	
	public static Unit createUnit(String unitDesc){
		
		if (unitDesc.equals(UnitFactory.METRIC_SYSTEM_LENGTH))
			return new MetricSysLength(0.0, "");
		else if (unitDesc.equals(UnitFactory.METRIC_SYSTEM_VOLUME))
			return new MetricSysVolume(0.0, "");
		else if (unitDesc.equals(UnitFactory.IMPERIAL_SYSTEM_LENGTH))
			return new ImperialSysLength(0.0, "");
		else if (unitDesc.equals(UnitFactory.IMPERIAL_SYSTEM_VOLUME))
			return new ImperialSysVolume(0.0, "");
		
		return null;
	}
}