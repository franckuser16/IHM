package model;

import java.util.HashMap;

public abstract class SI extends Unit
{
	private static final HashMap<String, Integer> PREFIX = new HashMap<String, Integer>(){ {
		
		put ("yocto",	-24);
		put ("zepto",	-21);
		put ("atto",	-18);
		put ("femto",	-15);
		put ("pico",	-12);
		put ("nano",	-9);
		put ("micro",	-6);
		put ("milli",	-3);
		put ("centi",	-2);
		put ("deci",	-1);
		put	("none",	0);
		put ("deca",	1);
		put ("hecto",	2);
		put ("kilo",	3);
		put ("mega",	6);
		put ("giga",	9);
		put ("tera",	12);
		put ("peta",	15);
		put ("exa",		18);
		put ("zetta",	21);
		put ("yotta",	24);
	} };
	
	private double prefix;
	private double prefix_ref;
	private double pas;
	
	public SI()
	{
	}

	public SI(Dimension dim, double quantity, String reference, double KofConversion)
	{
		super(dim, quantity, reference, KofConversion);
	}

	public SI(Dimension dim, double quantity, String reference, double KofConversion, String prefix, String prefix_ref, double pas)
	{
		super(dim, quantity, reference, KofConversion);
		this.pas = pas;
		this.prefix = Math.pow(10, (SI.PREFIX.get(prefix) * this.pas));
		this.prefix_ref = Math.pow(10, (SI.PREFIX.get(prefix_ref) * this.pas));
	}

	public double toReference()
	{
		return (this.getQuantity() * this.prefix) / this.prefix_ref;
	}

	public void fromReference(double qtOfRef)
	{
		this.setQuantity( (long) ((qtOfRef / this.prefix) * this.prefix_ref) );
	}

	public double getPrefix()
	{
		return this.prefix;
	}	

	public static Object[] getList()
	{
		//faire un mashup de reference et des prefix
		return SI.PREFIX.keySet().toArray();
	}
}