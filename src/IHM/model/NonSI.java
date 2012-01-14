package IHM.model;

import IHM.model.Unit;
/**
 *
 * @author jeremy
 */
public abstract class NonSI extends Unit
{
	private enum MesSystem {}
	
	public NonSI(Dimension dim, double quantity, String reference, double KofConversion, enum MesSystem)
	{
		super(dim, quantity, reference, KofConversion);
		this.MesSystem = MesSystem;
	}

	public double toReference()
	{
		return 0;
	}

	public void fromReference(double qtOfRef)
	{
			
	}
}
