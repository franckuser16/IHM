package model;

/**
 * @author franck
 *
 */
public class MetricSysLength extends SI
{
	private static final double MSL_K_CONV = 1;
	private static final Dimension MSL_DIMENSION = new Dimension(Dimension.LENGTH);
	private static final String MSL_NAME = "meter";
	
	/**
	 * @param quantity
	 * @param prefix
	 */
	public MetricSysLength(double quantity, String prefix)
	{
		super(MetricSysLength.MSL_DIMENSION, quantity, MetricSysLength.MSL_NAME, MetricSysLength.MSL_K_CONV, prefix, "none", 1);
	}
	/**
	 * @param quantity
	 * @param prefix
	 */
	public MetricSysLength(double quantity, double prefix_power)
	{
		super(MetricSysLength.MSL_DIMENSION, quantity, MetricSysLength.MSL_NAME, MetricSysLength.MSL_K_CONV, prefix_power, "none", 1);
	}

	public static void main(String[] args)
	{
			MetricSysLength unitA = new MetricSysLength(120, -2);
			ImperialSysLength unitB = new ImperialSysLength(0, "Mile");
			
			Converter cvt = unitA.getConverterTo(unitB);
			unitB = (ImperialSysLength)cvt.convert();
			System.out.println(unitB);
			
			MetricSysVolume unitC = new MetricSysVolume(367, "milli");
			ImperialSysVolume unitD = new ImperialSysVolume(0, "Cubic inch");

			Converter cvt1 = unitC.getConverterTo(unitD);
			unitD = (ImperialSysVolume)cvt1.convert();
			System.out.println(unitD);
			
			/*for (int i=0; i<unitA.getList().length;i++)
				System.out.println(unitA.getList()[i]);
			for (int i=0; i<unitB.getList().length;i++)
				System.out.println(unitB.getList()[i]);
			for (int i=0; i<unitC.getList().length;i++)
				System.out.println(unitC.getList()[i]);
			for (int i=0; i<unitD.getList().length;i++)
				System.out.println(unitD.getList()[i]);
			*/
	}

}
