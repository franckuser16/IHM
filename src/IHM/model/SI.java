package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author franck
 *
 */
public abstract class SI extends Unit
{
	/**
	 * 
	 */
	@SuppressWarnings("serial")
	private static final HashMap<String, Integer> PREFIX = new HashMap<String, Integer>(){ {
		
		put ("yocto",	-24);
		put ("zepto",	-21);
		put ("atto",	-18);
		put ("femto",	-15);
		put ("pico",	-12);
		put ("nano",	 -9);
		put ("micro",	 -6);
		put ("milli",	 -3);
		put ("centi",	 -2);
		put ("deci",	 -1);
		put ("",	  	  0);
		put ("deca",	  1);
		put ("hecto",	  2);
		put ("kilo",	  3);
		put ("mega",	  6);
		put ("giga",	  9);
		put ("tera",	 12);
		put ("peta",	 15);
		put ("exa",		 18);
		put ("zetta",	 21);
		put ("yotta",	 24);
	} };
	
	private String base;
	private double prefix;
	private double prefix_ref;
	private double pas;
	
	/**
	 * @param dim
	 * @param quantity
	 * @param reference
	 * @param KofConversion
	 * @param prefix
	 * @param prefix_ref
	 * @param pas
	 */
	public SI(Dimension dim, double quantity, String base, double KofConversion, String prefix, String prefix_ref, double pas)
	{
		super(dim, quantity, prefix, KofConversion);
		this.base = base;
		this.pas = pas;
		this.prefix = Math.pow(10, (SI.PREFIX.get(prefix) * this.pas));
		this.prefix_ref = Math.pow(10, (SI.PREFIX.get(prefix_ref) * this.pas));
	}

	/**
	 * @param dim
	 * @param quantity
	 * @param reference
	 * @param KofConversion
	 * @param prefix_power
	 * @param prefix_ref
	 * @param pas
	 */
	/*public SI(Dimension dim, double quantity, String base, double KofConversion, Double prefix_power, String prefix_ref, double pas)
	{
		super(dim, quantity, toStrgPrefixPower(prefix_power), KofConversion);
		this.base = base;
		this.pas = pas;
		this.prefix = Math.pow(10, (prefix_power * this.pas));
		this.prefix_ref = Math.pow(10, (SI.PREFIX.get(prefix_ref) * this.pas));
	}
	*/
	/* (non-Javadoc)
	 * @see model.Unit#toReference()
	 */
	public double toReference()
	{
		return (this.getQuantity() * this.prefix) / this.prefix_ref;
	}

	/* (non-Javadoc)
	 * @see model.Unit#fromReference(double)
	 */
	public void fromReference(double qtOfRef)
	{
		this.setQuantity( (long) ((qtOfRef / this.prefix) * this.prefix_ref) );
	}

	/**
	 * @return
	 */
	public double getPrefix()
	{
		return this.prefix;
	}	

	/* (non-Javadoc)
	 * @see model.Unit#getList()
	 */
	public Object[] getList()
	{
		//faire un mashup de reference et des prefix
		//return SI.PREFIX.keySet().toArray();
		ArrayList<String> liste = new ArrayList<String>();
		
		for (int i=0; i<SI.PREFIX.size(); i++)
			liste.add(SI.PREFIX.keySet().toArray()[i] + "-" + this.getBase());
		
		return liste.toArray();
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
	
	public String toStrgPrefixPower(Double prfx)
	{
		Entry<String, Integer> elt = null;
		Iterator<Map.Entry<String, Integer>> it = SI.PREFIX.entrySet().iterator();
		
		while (it.hasNext()){
			elt = it.next();
			if (elt.getValue().equals(prfx)) break;
		}
		
		return elt.getKey();
			
	}
}