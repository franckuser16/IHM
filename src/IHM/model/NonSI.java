package model;

import java.util.HashMap;

/**
 * @author franck
 *
 */
public abstract class NonSI extends Unit
{
	private HashMap<String, Double> MesSystem;
	
	/**
	 * @return
	 */
	public HashMap<String, Double> getMesSystem() {
		return MesSystem;
	}

	/**
	 * @param mesSystem
	 */
	public void setMesSystem(HashMap<String, Double> mesSystem) {
		MesSystem = mesSystem;
	}

	/**
	 * @param dim
	 * @param quantity
	 * @param reference
	 * @param KofConversion
	 * @param MesSystem
	 */
	public NonSI(Dimension dim, double quantity, String reference, double KofConversion, HashMap<String, Double> MesSystem)
	{
		super(dim, quantity, reference, KofConversion);
		setMesSystem(MesSystem);
	}

	/* (non-Javadoc)
	 * @see model.Unit#toReference()
	 */
	public double toReference()
	{
		return this.getQuantity() * MesSystem.get(this.getReference());
	}

	/* (non-Javadoc)
	 * @see model.Unit#fromReference(double)
	 */
	public void fromReference(double qtOfRef)
	{
		this.setQuantity(qtOfRef / MesSystem.get(this.getReference()));
	}
	
	/* (non-Javadoc)
	 * @see model.Unit#getList()
	 */
	public Object[] getList()
	{
		return MesSystem.keySet().toArray();
	}
}
