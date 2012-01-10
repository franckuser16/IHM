package model;
/**
 *
 * @author jeremy
 */
public abstract class SI extends Unit
{
	
    private long prefix;

    public SI()
    {
    }

    public long toReference()
    {
	    return this.quantity * this.prefix;
    }

}
