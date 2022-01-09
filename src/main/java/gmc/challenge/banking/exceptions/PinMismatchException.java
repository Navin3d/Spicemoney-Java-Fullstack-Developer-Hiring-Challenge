package gmc.challenge.banking.exceptions;

public class PinMismatchException extends RuntimeException {

	private static final long serialVersionUID = 5779899122127202468L;

	public PinMismatchException() {
		super("Pin Mis Matched...");
	}

	public PinMismatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PinMismatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PinMismatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PinMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
