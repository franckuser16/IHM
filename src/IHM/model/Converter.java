package model;

/**
 *
 * @author jeremy
 */
public class Converter {

	private Unit unitIn;
	private Unit unitOut;

	private Converter(Unit unitIn, Unit unitOut)
	{
		this.unitIn = unitIn;
		this.unitOut = unitOut;
	}

	public static Converter createConverter(Unit unitIn, Unit unitOut)
	{
		//trouver o� placer le isCompatible
		if (unitIn.isCompatible(unitOut))
			return new Converter(unitIn, unitOut);
		else
			return null;
	}

	public Unit convert()
	{
		double unitInQtOfRef = unitIn.toReference();
		double unitOutQtOfRef = ( (unitInQtOfRef * unitIn.getKofConversion()) / unitOut.getKofConversion() );
		unitOut.fromReference(unitOutQtOfRef);

		return unitOut;
	}
}
