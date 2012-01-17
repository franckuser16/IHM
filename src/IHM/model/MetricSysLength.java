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
		super(	MetricSysLength.MSL_DIMENSION,
				quantity,
				MetricSysLength.MSL_NAME,
				MetricSysLength.MSL_K_CONV,
				prefix, "",
				1);
	}
	/**
	 * @param quantity
	 * @param prefix
	 */
	/*public MetricSysLength(double quantity, double prefix_power)
	{
		super(MetricSysLength.MSL_DIMENSION, quantity, MetricSysLength.MSL_NAME, MetricSysLength.MSL_K_CONV, prefix_power, "none", 1);
	}
	*/

	public static void main(String[] args)
	{
			Unit unitA = new MetricSysLength(120, "");
			Unit unitB = new ImperialSysLength(5, "Mile");
			
			Converter cvt = unitB.getConverterTo(unitA);
			unitA = cvt.convert();
			System.out.println(unitA);
			
			Unit unitE = new MetricSysLength(0, "");
			Unit unitF = new MetricSysLength(0, "");
			
			unitE.setQuantity(120);
			unitE.setReference("");
			unitF.setReference("centimeter");
			
			Converter cvt2 = unitE.getConverterTo(unitF);
			unitF = cvt2.convert();
			System.out.println(unitF);
			
			Unit unitC = new MetricSysVolume(5, "");
			Unit unitD = new ImperialSysVolume(367, "Cubic inch");

			Converter cvt1 = unitD.getConverterTo(unitC);
			unitC = cvt1.convert();
			System.out.println(unitC);
			
			//for (int i=0; i<unitA.getList().length;i++)
			//	System.out.println(unitA.getList()[i]);
//			for (int i=0; i<unitB.getList().length;i++)
//				System.out.println(unitB.getList()[i]);
//			for (int i=0; i<unitC.getList().length;i++)
//				System.out.println(unitC.getList()[i]);
//			for (int i=0; i<unitD.getList().length;i++)
//				System.out.println(unitD.getList()[i]);

	}

}
