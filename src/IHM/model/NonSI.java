package model;

import java.util.HashMap;

public abstract class NonSI extends Unit
{
	private static HashMap<String, Double> MesSystem;
	
	public static HashMap<String, Double> getMesSystem() {
		return MesSystem;
	}

	public static void setMesSystem(HashMap<String, Double> mesSystem) {
		MesSystem = mesSystem;
	}

	public NonSI(Dimension dim, double quantity, String reference, double KofConversion, HashMap<String, Double> MesSystem)
	{
		super(dim, quantity, reference, KofConversion);
		setMesSystem(MesSystem);
	}

	public double toReference()
	{
		return this.getQuantity() * MesSystem.get(this.getReference());
	}

	public void fromReference(double qtOfRef)
	{
		this.setQuantity(qtOfRef / MesSystem.get(this.getReference()));
	}
	
	public Object[] getList()
	{
		return MesSystem.keySet().toArray();
	}
}
