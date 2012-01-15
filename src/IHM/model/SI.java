package model;

/**
 *
 * @author jeremy
 */
public abstract class SI extends Unit
{
	private enum prefix{
		
		YOCTO	(-24),
		ZEPTO	(-21),
		ATTO	(-18),
		FEMTO	(-15),
		PICO	(-12),
		NANO	(-9),
		MICRO	(-6),
		MILLI	(-3),
		CENTI	(-2),
		DECI	(-1),
		DECA	(1),
		HECTO	(2),
		KILO	(3),
		MEGA	(6),
		GIGA	(9),
		TERA	(12),
		PETA	(15),
		EXA		(18),
		ZETTA	(21),
		YOTTA	(24);

		private int power;

		prefix(int power)
		{
			this.power = power;
		}
	}
	
	private double prefix;
	private double prefix_ref;
	private double pas;
	//liste des prefix deca...
	//permettant la cr?ation du nom en fct des param prefix et reference

	public SI()
	{
	}

	public SI(Dimension dim, double quantity, String reference, double KofConversion)
	{
		super(dim, quantity, reference, KofConversion);
	}

	public SI(Dimension dim, double quantity, String reference, double KofConversion, double prefix, double prefix_ref, double pas)
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

	public double getPrefix()
	{
		return this.prefix;
	}
}
