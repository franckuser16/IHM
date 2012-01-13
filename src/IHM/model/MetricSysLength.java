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

	public MetricSysLength(double quantity, int prefix)
	{
		super(new Dimension(Dimension.LENGTH), quantity, MetricSysLength.MSL_K_CONV, "meter", prefix, 1, 10);
	}

	public static void main(String[] args)
	{
			MetricSysLength unitA = new MetricSysLength(120, 10);
			MetricSysVolume unitB = new MetricSysVolume(0, 100);

			Converter cvt = unitA.getConverterTo(unitB);
			unitB = (MetricSysVolume)cvt.convert();
			System.out.println(unitB);
	}

}
