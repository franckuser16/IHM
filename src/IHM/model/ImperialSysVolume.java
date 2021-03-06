package model;

import java.util.HashMap;

/**
 * @author franck
 *
 */
public class ImperialSysVolume extends NonSI
{

	private static final double ISV_K_CONV = 28.4130742;
	private static final Dimension ISV_DIMENSION = new Dimension(Dimension.VOLUME);

	/**
	 * 
	 */
	@SuppressWarnings("serial")
	private static final HashMap<String, Double> ISV_Units = new HashMap<String, Double>() {{

		put ("Fluid dram",	new Double(0.125));
		put ("Cubic inch",	new Double(0.5767440239));
		put ("Fluid ounce", new Double(1.0));
		put ("Gill",		new Double(5.0));
		put ("Pint",		new Double(20.0));
		put ("Gallon",		new Double(160.0));
	}};

	/**
	 * @param quantity
	 * @param name
	 */
	public ImperialSysVolume(double quantity, String name) 
	{
		super(	ImperialSysVolume.ISV_DIMENSION,
				quantity,
				name,
				ImperialSysVolume.ISV_K_CONV,
				ISV_Units);
	}
	
}