package ir4.arp.parklot.boy;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.report.ReportItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by on 10/26/2017.
 */
public class ParkingDirectorTest {
    @Test
    public void should_return_empty_when_generate_given_0_manager() {
        ParkingDirector parkingDirector = new ParkingDirector();

        List<ReportItem> reportItems = parkingDirector.generateReport();

        assertEquals(0, reportItems.size());
    }


    @Test
    public void should_return_correct_str_when_generate_given_1_manager_1_parking_boy() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 20, "A");
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        parkingManager.addParkingAble(parkingBoy);
        ParkingDirector parkingDirector = new ParkingDirector();
        parkingDirector.addParkingManager(parkingManager);
        String expectedReport = "";
        // when
        List<ReportItem> reportItems = parkingDirector.generateReport();
        //Then
        assertEquals(3, reportItems.size());
    }

    private ParkingLot initParkingLot(String parkingLotName, int parkingVolume, int parkedCar, String carPrefixName) {
        ParkingLot parkingLot = new ParkingLot(parkingLotName, parkingVolume);
        for (int i = 1; i <= parkedCar; i++) {
            Car car = new Car(carPrefixName + i);
            parkingLot.parkCar(car);
        }
        return parkingLot;
    }
}
