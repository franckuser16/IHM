package model;

public class IntSysMass extends SI {
	
	private static final double ISM_K_CONV = 1;
	private static final Dimension ISM_DIMENSION = new Dimension(Dimension.MASS);
	private static final String ISM_NAME = "gram";

	/**
	 * @param quantity
	 * @param prefix
	 */
	public IntSysMass(double quantity, String prefix)
	{
		super(	IntSysMass.ISM_DIMENSION,
				quantity,
				IntSysMass.ISM_NAME,
				IntSysMass.ISM_K_CONV,
				prefix,
				"kilo",
				1);
	}
}
