package model;

import java.util.HashMap;

/**
 *
 * @author jeremy
 */
public class ImperialSysLength extends NonSI
{
	private static final double ISL_K_CONV = 0.0254;
	private static final Dimension ISL_DIMENSION = new Dimension(Dimension.LENGTH);

	private static final HashMap<String, Double> ISL_Units = new HashMap<String, Double>() {{

		put ("Inch", new Double(1.0));
		put ("Foot", new Double(12.0));
		put ("Yard", new Double(36.0));
		put ("Mile", new Double(63360.0));
	}};

	public ImperialSysLength(double quantity, String name) 
	{
		//!!! name est employ� comme reference : faux
		super(ImperialSysLength.ISL_DIMENSION, quantity, name, ImperialSysLength.ISL_K_CONV, ISL_Units);
		//selectionner la bonne valeur d'enum depuis la reference
	}
}