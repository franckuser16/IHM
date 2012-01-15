package IHM.model;
/**
 *
 * @author jeremy
 */
public class Dimension
{
	public static final int NO_DIMENSION = -1;
	public static final int LENGTH = 0;
	public static final int AREA = 1;
	public static final int VOLUME = 2;
	public static final int HEAT = 3;
	public static final int PRESSURE = 4;

	private int nature;

	public Dimension(int nature)
	{
		this.nature = nature;
	}

	public boolean equals(Object dimOut)
	{
		return this.nature == ((Dimension)dimOut).getNature();
	}

	public int getNature()
	{
		return this.nature;
	}
}
