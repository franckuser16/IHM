package IHM.model;

import IHM.model.SI;
import IHM.model.Dimension;

//pour le test
import IHM.model.Converter;
import IHM.model.ImperialSysLength;

/**
 *
 * @author jeremy
 */
public class MetricSysLength extends SI
{
	private static final double MSL_K_CONV = 1;
	private static final Dimension MSL_DIMENSION = new Dimension(Dimension.LENGTH);

	
	public MetricSysLength(double quantity, double prefix)
	{
		super(MetricSysLength.MSL_DIMENSION, quantity, "meter", MetricSysLength.MSL_K_CONV, prefix, 1, 10);
	}

	public static void main(String[] args)
	{
			MetricSysLength unitA = new MetricSysLength(120, 0.001);
			ImperialSysLength unitB = new ImperialSysLength(0, "Mile");

			Converter cvt = unitA.getConverterTo(unitB);
			unitB = (ImperialSysLength)cvt.convert();
			System.out.println(unitB);
			
			MetricSysVolume unitC = new MetricSysVolume(367, 10);
			ImperialSysVolume unitD = new ImperialSysVolume(0, "Cubic inch");

			Converter cvt1 = unitC.getConverterTo(unitD);
			unitD = (ImperialSysVolume)cvt1.convert();
			System.out.println(unitD);
			
	}

}
