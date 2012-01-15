package IHM.model;

import IHM.model.Unit;
/**
 *
 * @author jeremy
 */
public abstract class SI extends Unit
{
	private enum PREFIX{
		
		YOCTO	("yocto",	-24);
		ZEPTO	("zepto",	-21);
		ATTO	("atto",	-18);
		FEMTO	("femto", 	-15);
		PICO	("pico",	-12);
		NANO	("nano,"	-9);
		MICRO	("micro",	-6);
		MILLI	("mili",	-3);
		CENTI
		D�CI
		D�CA
		HECTO
		KILO
		M�GA
		GIGA
		T�RA
		P�TA
		EXA
		ZETTA
		YOTTA
		
		yocto
		zepto
		atto
		femto
		pico
		nano	
		micro
		milli
		centi
		d�ci
		d�ca
		hecto
		kilo
		m�ga
		giga
		t�ra
		p�ta
		exa
		zetta
		yotta

	}
	
	private double prefix;
	private double prefix_ref;
	private double pas;
	//liste des prefix deca...
	//permettant la cr�ation du nom en fct des param prefix et reference

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
