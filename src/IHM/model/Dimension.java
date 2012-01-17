package model;

import java.util.HashMap;

/**
 * @author franck
 *
 */
public class Dimension
{
	public static final int NO_DIMENSION = -1;
	public static final int LENGTH = 0;
	public static final int AREA = 1;
	public static final int VOLUME = 2;
	public static final int MASS = 3;
	public static final int TIME = 4;
	public static final int ELECTRIC_CURRENT = 5;
	public static final int THERMODYNAMIC_TEMPERATURE = 6;
	public static final int LUMINOUS_INTENSITY = 7;
	public static final int AMOUNT_OF_SUBSTANCE = 8;

	private int nature;

	/**
	 * @param nature
	 */
	public Dimension(int nature)
	{
		this.nature = nature;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object dimOut)
	{
		return this.nature == ((Dimension)dimOut).getNature();
	}

	/**
	 * @return
	 */
	public int getNature()
	{
		return this.nature;
	}
}