package exceptions;

public class InvalidScaleException extends Throwable {
    public InvalidScaleException(String message,double value) {
        super(String.format("%s %s",message,value));
    }
}
