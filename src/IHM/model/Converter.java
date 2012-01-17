package model;

/**
 * @author franck
 *
 */
public class Converter {

	private Unit unitIn;
	private Unit unitOut;

	/**
	 * @param unitIn
	 * @param unitOut
	 */
	private Converter(Unit unitIn, Unit unitOut)
	{
		this.unitIn = unitIn;
		this.unitOut = unitOut;
	}

	/**
	 * @param unitIn
	 * @param unitOut
	 * @return
	 */
	public static Converter createConverter(Unit unitIn, Unit unitOut)
	{
		//trouver ou placer le isCompatible
		if (unitIn.isCompatible(unitOut))
			return new Converter(unitIn, unitOut);
		else
			return null;
	}

	/**
	 * @return
	 */
	public Unit convert()
	{
		double unitInQtOfRef = unitIn.toReference();
		double unitOutQtOfRef = ( (unitInQtOfRef * unitIn.getKofConversion()) / unitOut.getKofConversion() );
		unitOut.fromReference(unitOutQtOfRef);

		return unitOut;
	}
}
