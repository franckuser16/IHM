package model;

/**
 * @author franck
 *
 */
public abstract class Unit
{
	private static final double NULL_QUANTITY = 0;
	private static final String NO_NAME = "";
	private static final double NO_CONVERSION = -1;

	private Dimension dim;
	private double quantity;
	private String name;
	private double KofConversion;
	
	/**
	 * 
	 */
	public Unit()
	{
		this.dim = new Dimension(Dimension.NO_DIMENSION);
		this.quantity = Unit.NULL_QUANTITY;
		this.name = Unit.NO_NAME;
		this.KofConversion = Unit.NO_CONVERSION;
	}

	/**
	 * @param dim
	 * @param quantity
	 * @param reference
	 * @param KofConversion
	 */
	public Unit(Dimension dim, double quantity, String reference, double KofConversion)
	{
		this.dim = dim;
		this.quantity = quantity;
		this.name = reference;
		this.KofConversion = KofConversion;
	}

	/**
	 * @param unit
	 * @return
	 */
	public boolean isCompatible(Unit unit)
	{
		return this.getDimension().equals(unit.getDimension());
	}

	/**
	 * @return
	 */
	public double getKofConversion()
	{
		return this.KofConversion;
	}

	/**
	 * @param unitOut
	 * @return
	 */
	public Converter getConverterTo(Unit unitOut)
	{
		return Converter.createConverter(this, unitOut);
	}

	public void setDimension(Dimension dim)
	{
		this.dim = dim;
	}

	/**
	 * @return
	 */
	public Dimension getDimension()
	{
		return this.dim;
	}

	/**
	 * @return
	 */
	public double getQuantity()
	{
		return this.quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @return
	 */
	public abstract double toReference();

	/**
	 * @param qtOfRef
	 */
	public abstract void fromReference(double qtOfRef);

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Quantity: " + this.getQuantity();
	}

	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param reference
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public abstract Object[] getList();
}
