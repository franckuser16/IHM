package IHM.model;

import IHM.model.Unit;
/**
 *
 * @author jeremy
 */
public abstract class NonSI extends Unit
{
	public NonSI(Dimension dim, double quantity, String reference, double KofConversion)
	{
		super(dim, quantity, reference, KofConversion);
	}

	public double toReference()
	{
		return 0;
	}

	public void fromReference(double qtOfRef)
	{
			
	}
}
