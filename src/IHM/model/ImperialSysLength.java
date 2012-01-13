package IHM.model;
/**
 *
 * @author jeremy
 */
public class ImperialSysLength extends NonSI
{
		private static final double ISL_K_CONV = 123;

		private enum ISL_Units {

				Inch (1.0),
				Foot (12.0),
				Yard (36.0),
				Mile (63360.0);

				private final double ratio_to_reference;

				ISL_Units(double ratio_to_reference)
				{
						this.ratio_to_reference = ratio_to_reference;
				}

		} 

		public ImperialSysLength(double quantity, String name) 
		{
				//!!! name est employé comme reference : faux
				super(new Dimension(Dimension.LENGTH), quantity, name, ImperialSysLength.ISL_K_CONV);
				//selectionner le bonne valeur d'enum depuis la reference
		}

		public void fromReference(double qtOfRef)
		{
		}

		public double toReference()
		{
				return 0;
		}
}
