package hu.uni.djavorek.model.exception;

public class JobAlreadyExistsException extends RuntimeException {
    public JobAlreadyExistsException() {
    }

    public JobAlreadyExistsException(String message) {
        super(message);
    }

    public JobAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
