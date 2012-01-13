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

	public SI(Dimension dim, double quantity, String reference, double KofConversion)
	{
		super(dim, quantity, reference);
	}

	public SI(Dimension dim, double quantity, String reference, double KofConversion, long prefix, long prefix_ref, long pas)
	{
		super(dim, quantity, reference, KofConversion);
		this.prefix = prefix;
		this.prefix_ref = prefix_ref;
		this.pas = pas;
	}

	public double toReference()
	{
		return (this.getQuantity() * this.prefix) / this.prefix_ref; //Math.pow(10, this.prefix_ref);
	}

	public void fromReference(double qtOfRef)
	{
		this.setQuantity( (long) ((qtOfRef / this.prefix) * this.prefix_ref) ); //Math.pow(10, this.prefix_ref)) );
	}

	public long getPrefix()
	{
		return this.prefix;
	}
}
