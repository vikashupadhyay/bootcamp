package parking;

public class ParkingLotIsFullException extends RuntimeException {
    public ParkingLotIsFullException() {
        super("Parking lot is full");
    }

}
