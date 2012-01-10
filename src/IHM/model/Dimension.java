package model;
/**
 *
 * @author jeremy
 */
public class Dimension
{

    public static final LENGTH = 0;
    public static final AREA = 1;
    public static final VOLUME = 2;
    public static final HEAT = 3;

    private int nature;

    public Dimension(int nature)
    {
	this.nature = nature;
    }
    
    public boolean equals(Objetc dimOut)
    {
        return this.nature.equals(((Dimension)dimOut).getNature());
    }

    public int getNature()
    {
	return this.nature;
    }
}
