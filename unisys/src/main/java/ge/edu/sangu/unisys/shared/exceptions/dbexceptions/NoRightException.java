package ge.edu.sangu.unisys.shared.exceptions.dbexceptions;

public class NoRightException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoRightException ()
	{
		super();
	}

	public NoRightException(String message){
		super(message);
	}
}