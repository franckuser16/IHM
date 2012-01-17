package model;

/**
 * @author franck
 *
 */
public class MetricSysVolume extends SI
{
	private static final double MSV_K_CONV = 1;
	private static final Dimension MSV_DIMENSION = new Dimension(Dimension.VOLUME);
	private static final String MSV_NAME = "meter³";

	/**
	 * @param quantity
	 * @param prefix
	 */
	public MetricSysVolume(double quantity, String prefix)
	{
		super(	MetricSysVolume.MSV_DIMENSION,
				quantity,
				MetricSysVolume.MSV_NAME,
				MetricSysVolume.MSV_K_CONV,
				prefix,
				"centi",
				3);
	}
	
	/**
	 * @param quantity
	 * @param prefix
	 */

//	public MetricSysVolume(double quantity, double prefix_power)
//	{
//		super(MetricSysVolume.MSV_DIMENSION, quantity, MetricSysVolume.MSV_NAME, MetricSysVolume.MSV_K_CONV, prefix_power, "centi", 3);
//	}
}

