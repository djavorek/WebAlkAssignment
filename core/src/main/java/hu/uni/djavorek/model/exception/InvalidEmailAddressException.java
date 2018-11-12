package hu.uni.djavorek.model.exception;

public class InvalidEmailAddressException extends RuntimeException{

    public InvalidEmailAddressException() {
    }

    public InvalidEmailAddressException(String s) {
        super(s);
    }

    public InvalidEmailAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmailAddressException(Throwable cause) {
        super(cause);
    }
}
