package IHM.model;
/**
 *
 * @author jeremy
 */
public class ImperialSysLength extends NonSI
{
		private static final double ISL_K_CONV = 0.0254;

		private enum ISL_Units implements NonSIMesSys{

				INCH ("Inch", 1.0),
				FOOT ("Foot", 12.0),
				YARD ("Yard", 36.0),
				MILE ("Mile", 63360.0);

				private final String name;
				private final double ratio_to_reference;

				ISL_Units(String name, double ratio_to_reference)
				{
						this.name = name;
						this.ratio_to_reference = ratio_to_reference;
				}
				
				public double toReference(double quantity)
				{
					return quantity * this.ratio_to_reference;
				}

				public double fromReference(double qtOfRef)
				{
					return qtOfRef / this.ratio_to_reference;
				}
		} 

		public ImperialSysLength(double quantity, String name) 
		{
				//!!! name est employé comme reference : faux
				super(new Dimension(Dimension.LENGTH), quantity, name, ImperialSysLength.ISL_K_CONV, ISL_Units.INCH);
				//selectionner la bonne valeur d'enum depuis la reference
		}

		public void fromReference(double qtOfRef)
		{
		}

		public double toReference()
		{
				return 0;
		}
}
