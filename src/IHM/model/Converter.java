package IHM.model;

/**
 *
 * @author jeremy
 */
public class Converter {

	private Unit unitIn;
	private Unit unitOut;

    public Converter(Unit unitIn, Unit unitOut)
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
		return new MetricSysLength(0);
    }

}
