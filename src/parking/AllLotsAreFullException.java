package parking;

public class AllLotsAreFullException extends RuntimeException {
    public AllLotsAreFullException() {
        super("All lots are full");
    }
}
