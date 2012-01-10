package model;

import java.awt.Dimension;

import model.Converter;


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
    }

    public boolean isCompatible(Unit unit)
    {
        return this.getDimension().equals(unit.getDimension());
    }

    public Converter getConverter()
    {
        return this.converter;
    }

    public Converter getConverterTo(Unit unitOut)
    {
        return Converter.createConverter(this, unitOut);
    }

    public Dimension getDimension()
    {
        return this.dim;
    }

    public long toReference()
    {
    }
}
