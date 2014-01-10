package ge.edu.sangu.unisys.shared.utils;

public class UtilitClass {

	public void checkForNull(Object object) {
		Boolean objectIsNull = IsNull(object);
		
		if ( objectIsNull == true ) {
			throw new NullPointerException();
		}
	}

	private Boolean IsNull(Object object) {
		Boolean objectIsNull = (object == null);
		
		return objectIsNull;
	}

}