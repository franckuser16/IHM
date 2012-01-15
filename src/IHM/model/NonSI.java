package model;

import java.util.HashMap;

public abstract class NonSI extends Unit
{
	private HashMap<String, Double> MesSystem;
	
	public NonSI(Dimension dim, double quantity, String reference, double KofConversion, HashMap<String, Double> MesSystem)
	{
		super(dim, quantity, reference, KofConversion);
		this.MesSystem = MesSystem;
	}

	public double toReference()
	{
		return this.getQuantity() * this.MesSystem.get(this.getReference());
	}

	public void fromReference(double qtOfRef)
	{
		this.setQuantity(qtOfRef / this.MesSystem.get(this.getReference()));
	}
	
	public String[] getList()
	{
		return (String[])MesSystem.keySet().toArray();
	}
}
