package parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AttendantTest {
    @Test
    public void ParkingLotShouldParkACar() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(1);
        attendant.addParkingLot(parkingLot);

        int totalNoOfCar = attendant.park(new Car());
        Assert.assertEquals(totalNoOfCar,1);

    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void ParkingLotShouldThrowExceptionWhenLotIsFull() {
        Car car = new Car();
        Attendant attendant = new Attendant();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);

        attendant.addParkingLot(firstParkingLot);
        attendant.addParkingLot(secondParkingLot);

        attendant.park(car);
        attendant.park(car);
        thrown.expect(AllLotsAreFullException.class);
        attendant.park(new Car());

    }

    @Test
    public void AssistantCanParkACar() {
        Attendant attendant = new Attendant();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        attendant.addParkingLot(firstParkingLot);
        attendant.addParkingLot(secondParkingLot);

    }
}