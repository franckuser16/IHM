package IHM.model;

import IHM.model.Converter;
import IHM.model.Dimension;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeremy
 */
public abstract class Unit
{
	private static final int NULL_QUANTITY = 0;
	private static final String NULL_REFERENCE = "";

	private Dimension dim;
	private long quantity;
	private String reference;
	//pas besoin de Converter en param, il est retourné par getConverterTo()
	//private Converter converter;

	public Unit()
	{
		this.dim = new Dimension(Dimension.NO_DIMENSION);
		this.quantity = Unit.NULL_QUANTITY;
		this.reference = NULL_REFERENCE;
	}

	public Unit(Dimension dim, long quantity, String reference)
	{
		this.dim = dim;
		this.quantity = quantity;
		this.reference = reference;
	}

	public boolean isCompatible(Unit unit)
	{
		return this.getDimension().equals(unit.getDimension());
	}

	/*
	   public Converter getConverter()
	   {
	   return this.converter;
	   }
	   */

	public Converter getConverterTo(Unit unitOut)
	{
		return Converter.createConverter(this, unitOut);
	}

	public Dimension getDimension()
	{
		return this.dim;
	}

	public long getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(long quantity)
	{
		this.quantity = quantity;
	}

	public abstract double toReference();

	public abstract void fromReference(double qtOfRef);

	public String toString()
	{
		return "Quantity: " + this.getQuantity();
	}
}
