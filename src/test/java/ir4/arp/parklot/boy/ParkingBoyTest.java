package ir4.arp.parklot.boy;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.exception.NoAvailableParkingSpacesException;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

public class ParkingBoyTest {

    @Test
    public void should_return_Ticket_When_park_car_given_available_parking_spaces() {
        //given
        int[] parkedCars = {0};
        ParkingBoy parkingBoy = initParkingBoy(1, parkedCars);
        Car car = new Car("B1");
        //when
        ParkingTicket ticket = parkingBoy.parkCar(car);
        //then
        assertEquals("P1-TB1", ticket.getTicketNo());
    }

    @Test(expected = NoAvailableParkingSpacesException.class)
    public void should_return_exception_When_park_car_given_unavailable_parking_spaces() {
        //given
        int[] parkedCars = {100};
        ParkingBoy parkingBoy = initParkingBoy(1, parkedCars);
        Car car = new Car("B1");
        //when
        parkingBoy.parkCar(car);
    }

    @Test
    public void should_return_ticket_When_park_car_given_two_emtpy_parkinglots() {
        //given
        int[] parkedCars = {0, 0};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        Car car = new Car("B1");
        //when
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        //then
        assertEquals("P1-TB1", parkingTicket.getTicketNo());
    }

    @Test
    public void should_return_ticket_When_park_car_given_two_parkinglots_each_with_available_parking_spaces() {
        //given
        int[] parkedCars = {30, 30};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        Car car = new Car("B31");
        //when
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        //then
        assertEquals("P1-TB31", parkingTicket.getTicketNo());
    }

    @Test
    public void should_return_ticket_When_park_car_given_two_parkinglots_one_full_other_with_available_parking_spaces() {
        //given
        int[] parkedCars = {100, 30};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        Car car = new Car("A101");
        //when
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        //then
        assertEquals("P2-TA101", parkingTicket.getTicketNo());
    }

    @Test(expected = NoAvailableParkingSpacesException.class)
    public void should_return_ticket_When_park_car_given_two_parkinglots_unavailable_parking_spaces() {
        //given
        int[] parkedCars = {100, 100};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        Car car = new Car("A101");
        //when
        parkingBoy.parkCar(car);
    }

    @Test
    public void should_return_car_When_park_car_given_one_car_parked_by_parkingBoy() {
        //given
        int[] parkedCars = {0};
        ParkingBoy parkingBoy = initParkingBoy(1, parkedCars);
        Car expectedCar = new Car("A101");
        ParkingTicket parkingTicket = parkingBoy.parkCar(expectedCar);
        //when
        Car actualCar = parkingBoy.pickUpCar(parkingTicket);
        //Then
        assertSame(expectedCar, actualCar);

    }

    @Test
    public void should_return_car_When_pickup_car_given_two_parkinglots_one_car_parked_by_parkingBoy() {
        //given
        int[] parkedCars = {100, 9};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        Car expectedCar = new Car("B10");
        ParkingTicket parkingTicket = parkingBoy.parkCar(expectedCar);
        //when
        Car actualCar = parkingBoy.pickUpCar(parkingTicket);
        //Then
        assertSame(expectedCar, actualCar);
    }

    @Test(expected = ParkingTicketInValidException.class)
    public void should_return_exception_when_pickup_car_with_invalid_ticket() {
        //given
        int[] parkedCars = {1, 1};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        ParkingTicket parkingTicket = new ParkingTicket("P1", "A2");
        //when
        parkingBoy.pickUpCar(parkingTicket);
    }

    @Test
    public void should_return_ticket_of_P1_When_pickup_car_from_full_parkinglot_P1() {
        //given
        int[] parkedCars = {100, 30};
        ParkingBoy parkingBoy = initParkingBoy(2, parkedCars);
        parkingBoy.pickUpCar(new ParkingTicket("P1", "A10"));
        Car car = new Car("A101");
        //when
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        //then
        assertEquals("P1-TA101", parkingTicket.getTicketNo());
    }

    private ParkingLot initParkCar(ParkingLot parkingLot, int parkedCar, String carName) {
        for (int i = 1; i <= parkedCar; i++) {
            Car car = new Car(carName + i);
            parkingLot.parkCar(car);
        }
        return parkingLot;
    }

    private ParkingBoy initParkingBoy(int masteredParkingLotNum, int[] parkedCar) {
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 1; i <= masteredParkingLotNum; i++) {
            ParkingLot parkinglot = new ParkingLot("P" + i, 100);
            String carName = "" + (char) ('A' + i - 1);
            initParkCar(parkinglot, parkedCar[i - 1], carName);
            parkingBoy.addParkingLot(parkinglot);
        }
        return parkingBoy;
    }
}
