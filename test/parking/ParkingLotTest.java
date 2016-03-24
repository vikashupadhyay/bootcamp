package parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingLotTest {
    @Test
    public void ParkingLotShouldAddACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        int park = parkingLot.park(new Car());
        Assert.assertEquals(park,1);

    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void ParkingLotShouldThrowExceptionWhileParkACarWhenLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(0);
        thrown.expect(ParkingLotIsFullException.class);
        parkingLot.park(new Car());
    }
}