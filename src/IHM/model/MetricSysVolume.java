package IHM.model;

import IHM.model.SI;
/**
 *
 * @author jeremy
 */
public class MetricSysVolume extends SI
{

	public MetricSysVolume(double quantity, int prefix)
	{
		super(new Dimension(Dimension.VOLUME), quantity, "metercubic", prefix, 1, 1000);
	}
}
