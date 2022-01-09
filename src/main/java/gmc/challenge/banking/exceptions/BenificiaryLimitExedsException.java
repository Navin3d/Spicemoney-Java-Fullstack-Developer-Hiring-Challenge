package gmc.challenge.banking.exceptions;

public class BenificiaryLimitExedsException extends RuntimeException {

	public BenificiaryLimitExedsException() {
		super("Exeeds limit");
	}

	public BenificiaryLimitExedsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BenificiaryLimitExedsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BenificiaryLimitExedsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BenificiaryLimitExedsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
