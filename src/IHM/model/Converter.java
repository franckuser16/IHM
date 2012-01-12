package IHM.model;

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
		return new Converter(unitIn, unitOut);
	}

	public Unit convert()
	{
		long unitInQtOfRef = unitIn.toReference();
		long unitOutQtOfRef = unitInQtOfRef / this.getKofConversion();
		unitOut.fromReference(unitOutQtOfRef);

		return unitOut;
	}

	public long getKofConversion()
	{
		return 1;
	}

}
