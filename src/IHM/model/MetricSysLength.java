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
	
	public MetricSysLength()
	{
		this(0, 0);
	}

	public MetricSysLength(double quantity, double prefix)
	{
		super(new Dimension(Dimension.LENGTH), quantity, "meter", MetricSysLength.MSL_K_CONV, prefix, 1, 10);
	}

	public static void main(String[] args)
	{
			MetricSysLength unitA = new MetricSysLength(120, 0.001);
			ImperialSysLength unitB = new ImperialSysLength(0, "Mile");

			Converter cvt = unitA.getConverterTo(unitB);
			unitB = (ImperialSysLength)cvt.convert();
			System.out.println(unitB);
	}

}
