package BusReservation;

public class reserveException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public reserveException(String message) {
        super(message);
    }

    public reserveException(String message, Throwable cause) {
        super(message, cause);
    }

    public reserveException(Throwable cause) {
        super(cause);
    }

    public reserveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public reserveException() {
    }

}
