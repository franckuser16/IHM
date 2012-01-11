package IHM.model;

import java.awt.Dimension;

import IHM.model.Converter;


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

    private Dimension dim;
    private int quantity;
    private String reference;
    //pas besoin de Converter en param, il est retourné par getConverterTo()
    //private Converter converter;

    public Unit()
    {
			this.dim = new Dimension();
			this.quantity = 0;
			this.reference = "";
    }

	public Unit(Dimension dim, int quantity, String reference)
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

	public int getQuantity()
	{
		return this.quantity;
	}

    public long toReference()
    {
			return 0;
    }
}
