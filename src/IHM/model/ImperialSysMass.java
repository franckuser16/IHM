package model;

import java.util.HashMap;

public class ImperialSysMass extends NonSI {
	
	private static final double ISM_K_CONV = 0.45359237;
	private static final Dimension ISM_DIMENSION = new Dimension(Dimension.MASS);

	/**
	 * 
	 */
	@SuppressWarnings("serial")
	private static final HashMap<String, Double> ISM_Units = new HashMap<String, Double>() {{

		put ("Grain",			new Double(1.0/7000.0));
		put ("Drachm",			new Double(1.0/256.0));
		put ("Ounce", 			new Double(1.0/16.0));
		put ("Pound",			new Double(1.0));
		put ("Stone",			new Double(14.0));
		put ("quarter",			new Double(28.0));
		put ("hundredweight",	new Double(112.0));
		put ("ton",				new Double(2240.0));
	}};

	/**
	 * @param quantity
	 * @param name
	 */
	public ImperialSysMass(double quantity, String name) 
	{
		super(	ImperialSysMass.ISM_DIMENSION,
				quantity,
				name,
				ImperialSysMass.ISM_K_CONV,
				ISM_Units);
	}

}
