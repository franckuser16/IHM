package IHM.model;

import IHM.model.Unit;
/**
 *
 * @author jeremy
 */
public abstract class SI extends Unit
{
	private long prefix;
	private long prefix_ref;
	private long pas;

	public SI()
	{
	}

	public SI(Dimension dim, long quantity, String reference)
	{
		super(dim, quantity, reference);
	}

	public SI(Dimension dim, long quantity, String reference, long prefix, long prefix_ref, long pas)
	{
		super(dim, quantity, reference);
		this.prefix = prefix;
		this.prefix_ref = prefix_ref;
		this.pas = pas;
	}

	public long toReference()
	{
		return (this.getQuantity() * this.prefix) / this.prefix_ref;
	}

	public void fromReference(long qtOfRef)
	{
		this.setQuantity( (qtOfRef / this.prefix) * this.prefix_ref );
	}

	public long getPrefix()
	{
		return this.prefix;
	}
}
