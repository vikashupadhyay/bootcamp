package parking;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Car> cars;
    private int lotSize;

    public ParkingLot(int lotSize) {
        this.lotSize = lotSize;
        cars = new ArrayList<Car>(lotSize);
    }

    public int park(Car car) {
        if(isFull())
            throw new ParkingLotIsFullException();
        cars.add(car);
        return cars.size();
    }

    public boolean isFull() {
        return  (numberOfCar()==lotSize);

    }

    private int numberOfCar() {
       return  cars.size();
    }
}
