package IHM.model;

import IHM.model.Unit;
/**
 *
 * @author jeremy
 */
public abstract class SI extends Unit
{
	
    private long prefix;
	private long pas;

	public SI()
	{
	}

    public SI(Dimension dim, int quantity, String reference, long prefix, long pas)
    {
		super(dim, quantity, reference);
		this.prefix = prefix;
		this.pas = pas;
    }

    public long toReference()
    {
	    return this.getQuantity() * this.prefix;
    }

}
