package gmc.challenge.banking.exceptions;

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6013857526797411051L;

	public AccountNotFoundException() {
		super("Account Not Found...");
	}

	public AccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
