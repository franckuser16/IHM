package model;

public class MetricSysLength extends SI
{
	private static final double MSL_K_CONV = 1;
	private static final Dimension MSL_DIMENSION = new Dimension(Dimension.LENGTH);
	private static final String MSL_NAME = "meter";
	
	public MetricSysLength(double quantity, String prefix)
	{
		super(MetricSysLength.MSL_DIMENSION, quantity, MetricSysLength.MSL_NAME, MetricSysLength.MSL_K_CONV, prefix, "none", 1);
	}

	public static void main(String[] args)
	{
			MetricSysLength unitA = new MetricSysLength(120, "centi");
			ImperialSysLength unitB = new ImperialSysLength(0, "Mile");
			
			Converter cvt = unitA.getConverterTo(unitB);
			unitB = (ImperialSysLength)cvt.convert();
			System.out.println(unitB);
			
			MetricSysVolume unitC = new MetricSysVolume(367, "milli");
			ImperialSysVolume unitD = new ImperialSysVolume(0, "Cubic inch");

			Converter cvt1 = unitC.getConverterTo(unitD);
			unitD = (ImperialSysVolume)cvt1.convert();
			System.out.println(unitD);
			
	}

}
