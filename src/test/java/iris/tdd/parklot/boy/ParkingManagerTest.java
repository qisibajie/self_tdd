package iris.tdd.parklot.boy;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;
import iris.tdd.parklot.exception.ParkingTicketInValidException;

import org.junit.Test;

import iris.tdd.parklot.ParkingTicket;

import static org.junit.Assert.assertSame;


public class ParkingManagerTest {
    @Test
    public void should_pickup_the_same_car_when_park_car_given_available_parking_spaces() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 0, "A");
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingAble(parkingLotA);
        Car car = new Car("A101");
        // when
        ParkingTicket parkingTicket = parkingManager.parkCar(car);
        // Then
        assertSame(car, parkingManager.pickUpCar(parkingTicket));
    }

    @Test(expected = NoAvailableParkingSpacesException.class)
    public void should_throw_exception_when_park_car_given_unavailable_parking_spaces() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 100, "A");
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingAble(parkingLotA);
        Car car = new Car("A101");
        // when
        parkingManager.parkCar(car);
    }

    @Test
    public void should_pickup_the_same_car_when_park_car_given_available_parking_spaces_by_parking_boy() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 20, "A");
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        parkingManager.addParkingAble(parkingBoy);
        Car car = new Car("A101");
        // when
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        //Then
        assertSame(car, parkingManager.pickUpCar(parkingTicket));
    }

    @Test(expected = NoAvailableParkingSpacesException.class)
    public void should_throw_exception_when_park_car_given_unavailable_parking_spaces_by_parking_boy() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 100, "A");
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        parkingManager.addParkingAble(parkingBoy);
        Car car = new Car("A101");
        // when
        parkingManager.parkCar(car);
    }

    @Test
    public void should_pickup_the_same_car_when_pick_up_car_given_car_parked_by_manger_self() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 0, "A");
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingAble(parkingLotA);
        Car expectedCar = new Car("A101");
        ParkingTicket parkingTicket = parkingManager.parkCar(expectedCar);
        // when
        Car actualCar = parkingManager.pickUpCar(parkingTicket);
        //Then
        assertSame(expectedCar, actualCar);
    }

    @Test
    public void should_pickup_the_same_car_when_pick_up_car_given_car_parked_by_parking_boy() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 0, "A");
        ParkingManager parkingManager = new ParkingManager();
        Car expectedCar = new Car("B101");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        ParkingTicket parkingTicket = parkingBoy.parkCar(expectedCar);
        parkingManager.addParkingAble(parkingBoy);
        // when
        Car actualCar = parkingManager.pickUpCar(parkingTicket);
        //Then
        assertSame(expectedCar, actualCar);
    }

    @Test(expected = ParkingTicketInValidException.class)
    public void should_return_invalid_ticket_exception_when_pick_up_car_given_invalid_ticket() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 20, "A");
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        ParkingTicket parkingTicket = new ParkingTicket("P1", "B101");
        parkingManager.addParkingAble(parkingBoy);
        // when
        parkingManager.pickUpCar(parkingTicket);
    }


    @Test
    public void should_pick_up_same_car_when_park_up_car_given_two_parking_boys_two_available_parking_lots() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 20, "A");
        ParkingLot parkingLotB = initParkingLot("P2", 200, 20, "B");
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(parkingLotB);
        parkingManager.addParkingAble(parkingBoy);
        parkingManager.addParkingAble(smartParkingBoy);
        Car expectedCar = new Car("A101");
        //
        ParkingTicket parkingTicket = parkingManager.parkCar(expectedCar);
        // then
        assertSame(expectedCar, parkingManager.pickUpCar(parkingTicket));
    }


    @Test(expected = NoAvailableParkingSpacesException.class)
    public void should_pick_up_same_car_when_park_up_car_given_two_parking_boys_two_unavailable_parking_lots() {
        // given
        ParkingLot parkingLotA = initParkingLot("P1", 100, 100, "A");
        ParkingLot parkingLotB = initParkingLot("P2", 200, 200, "B");
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotA);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(parkingLotB);
        parkingManager.addParkingAble(parkingBoy);
        parkingManager.addParkingAble(smartParkingBoy);
        Car expectedCar = new Car("A101");
        //
        parkingManager.parkCar(expectedCar);
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