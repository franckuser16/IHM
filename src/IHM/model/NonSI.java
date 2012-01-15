package IHM.model;

import IHM.model.Unit;
/**
 *
 * @author jeremy
 */
public abstract class NonSI extends Unit
{
	private NonSIMesSys MesSystem;
	
	public NonSI(Dimension dim, double quantity, String reference, double KofConversion, NonSIMesSys MesSystem)
	{
		super(dim, quantity, reference, KofConversion);
		this.MesSystem = MesSystem;
	}

	public double toReference()
	{
		return this.MesSystem.toReference(this.quantity);

	public void fromReference(double qtOfRef)
	{
		this.setQuantity(this.MesSystem.fromReference(qtOfRef));
	}
}
