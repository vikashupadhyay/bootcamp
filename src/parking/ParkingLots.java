package parking;

import java.util.ArrayList;

public class ParkingLots {
    ArrayList<ParkingLot> parkingLots;
    public ParkingLots() {
        parkingLots = new ArrayList<ParkingLot>();
    }
    public int addParkingLot (ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        return parkingLots.size();
    }

    private ParkingLot getParkingLot() {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull())
                return parkingLot;
        }
        throw new AllLotsAreFullException();
    }

    public int park(Car car) {
        ParkingLot lot = getParkingLot();
        return lot.park(car);
    }
}
