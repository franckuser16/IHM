package IHM.model;

import IHM.model.SI;
import IHM.model.Dimension;
/**
 *
 * @author jeremy
 */
public class MetricSysLength extends SI
{
	public MetricSysLength(int quantity, int prefix)
	{
		super(new Dimension(Dimension.LENGTH), quantity, "meter", prefix, 0, 10);
	}

}
