package exceptions;

public class IllegalBallInsertionException extends Throwable {
    public IllegalBallInsertionException() {
        super("Cannot put this ball");
    }
}
