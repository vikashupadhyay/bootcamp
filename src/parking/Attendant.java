package parking;

public class Attendant {
    private ParkingLots parkingLots;
    public Attendant() {
        parkingLots = new ParkingLots();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.addParkingLot(parkingLot);
    }

    public int park(Car car) {
       return parkingLots.park(car);
    }
}
