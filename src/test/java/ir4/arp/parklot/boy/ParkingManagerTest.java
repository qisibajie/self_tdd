package ir4.arp.parklot.boy;

import org.junit.Test;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;

import static junit.framework.Assert.*;

public class ParkingManagerTest {
    @Test
    public void should_return_ticket_when_park_car_given_available_parking_spaces() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 20, "A", 100);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingLot(parkingLotA);
        Car car = new Car("A101");
        // when
        ParkingTicket parkingTicket = parkingManager.parkCar(car);
        // Then
        assertEquals(car, parkingManager.pickUpCar(parkingTicket));
    }

    private ParkingLot initParkingLot(String parkName, int parkedCar, String carPrefixName, int parkingVolume) {
        ParkingLot parkingLot = new ParkingLot(parkName, parkingVolume);
        for (int i = 1; i <= parkedCar; i++) {
            Car car = new Car(carPrefixName + i);
            parkingLot.parkCar(car);
        }
        return parkingLot;
    }

}
