package exceptions;

public class InvalidComparisonException extends Throwable {
    public InvalidComparisonException() {
        super("Can't compare volume with measurement");
    }
}
