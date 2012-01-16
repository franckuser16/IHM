package model;

public class MetricSysVolume extends SI
{
	private static final double MSV_K_CONV = 1;
	private static final Dimension MSV_DIMENSION = new Dimension(Dimension.VOLUME);
	private static final String MSV_NAME = "meter³";

	public MetricSysVolume(double quantity, String prefix)
	{
		super(MetricSysVolume.MSV_DIMENSION, quantity, MetricSysVolume.MSV_NAME, MetricSysVolume.MSV_K_CONV, prefix, "centi", 3);
	}
}
