package IHM.model;

import IHM.model.SI;
/**
 *
 * @author jeremy
 */
public class MetricSysVolume extends SI
{
	private static final double MSL_K_CONV = 1;
	
	public MetricSysVolume(double quantity, int prefix)
	{
		super(new Dimension(Dimension.VOLUME), quantity, "metercubic", MetricSysVolume.MSL_K_CONV, prefix, 1, 1000);
	}
}
