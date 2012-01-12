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
	public MetricSysLength()
	{
		this(0, 0);
	}

	public MetricSysLength(long quantity, int prefix)
	{
		super(new Dimension(Dimension.LENGTH), quantity, "meter", prefix, 0, 10);
	}

	public static void main(String[] args)
	{
			MetricSysLength unitA = new MetricSysLength(12, 10);
			MetricSysLength unitB = new MetricSysLength(0, 100);

			Converter cvt = unitA.getConverterTo(unitB);
			unitB = (MetricSysLength)cvt.convert();
			System.out.println(unitB);
	}

}
