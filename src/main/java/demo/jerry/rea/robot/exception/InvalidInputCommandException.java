package demo.jerry.rea.robot.exception;

/**
 * An exception for invalid Input Command.
 * @author jzhang
 *
 */
public class InvalidInputCommandException extends RuntimeException {

    public InvalidInputCommandException() {
        super();
    }

    public InvalidInputCommandException(final String msg) {
        super(msg);
    }

    public InvalidInputCommandException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
