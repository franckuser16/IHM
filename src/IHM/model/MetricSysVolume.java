package IHM.model;

import IHM.model.SI;

public class MetricSysVolume extends SI
{
	private static final double MSV_K_CONV = 1;
	private static final Dimension MSV_DIMENSION = new Dimension(Dimension.VOLUME);

	public MetricSysVolume(double quantity, double prefix)
	{
		super(MetricSysVolume.MSV_DIMENSION, quantity, "cubic centimeter", MetricSysVolume.MSV_K_CONV, prefix, 0.000001, 1000);
	}
}
