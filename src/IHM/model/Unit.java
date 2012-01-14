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
	private static final double NULL_QUANTITY = 0;
	private static final String NULL_REFERENCE = "";
	private static final double NO_CONVERSION = -1;

	private Dimension dim;
	private double quantity;
	private String reference;
	private double KofConversion;
	//pas besoin de Converter en param, il est retourné par getConverterTo()
	//private Converter converter;

	public Unit()
	{
		this.dim = new Dimension(Dimension.NO_DIMENSION);
		this.quantity = Unit.NULL_QUANTITY;
		this.reference = Unit.NULL_REFERENCE;
		this.KofConversion = Unit.NO_CONVERSION;
	}

	public Unit(Dimension dim, double quantity, String reference, double KofConversion)
	{
		this.dim = dim;
		this.quantity = quantity;
		this.reference = reference;
		this.KofConversion = KofConversion;
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

	public double getKofConversion()
	{
		return this.KofConversion;
	}

	public Converter getConverterTo(Unit unitOut)
	{
		return Converter.createConverter(this, unitOut);
	}

	public Dimension getDimension()
	{
		return this.dim;
	}

	public double getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	public abstract double toReference();

	public abstract void fromReference(double qtOfRef);

	//a implementer
	//public abstract String[] enumerate();
	
	public String toString()
	{
		return "Quantity: " + this.getQuantity();
	}
}
