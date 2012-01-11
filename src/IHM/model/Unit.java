package model;

import java.awt.Dimension;


/**
 *
 * @author jeremy
 */
public abstract class Unit
{
    private Dimension dim;
    private int quantity;
    private String reference;
    private Converter convert;

    public Unit()
    {

    }
    
    public boolean isCompatible(Unit unit)
    {
        return this.getDimension().equals(unit.getDimension());
    }

    public Converter getConverter()
    {
        return convert;
    }

    public Dimension getDimension()
    {
        return dim;
    }
}
