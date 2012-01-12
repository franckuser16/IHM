package IHM.model;
/**
 *
 * @author jeremy
 */
public class ImperialSysLength extends NonSI
{
	public enum Unities {

		Inch (1.0),
		Foot (12.0),
		Yard (36.0),
		Mile (63360.0);

		private final double ratio_to_reference;

		Unities(double ratio_to_reference)
		{
			this.ratio_to_reference = ratio_to_reference;
		}

		public double toReference(double quantity){

			return quantity/this.ratio_to_reference;
		}

	}
		public void fromReference(double qtOfRef)
		{
		}

		public double toReference()
		{
				return 0;
		}
}
