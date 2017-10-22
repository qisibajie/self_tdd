package ir4.arp.parklot.boy;

import org.junit.Test;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.boy.SuperParkingBoy;
import ir4.arp.parklot.exception.NoAvaliableParkingSpacesException;

import static junit.framework.Assert.*;

public class SuperParkingBoyTest {

    @Test
    public void should_return_ticket_When_given_one_available_spaces_parking_lot() {
        //given
        int[] parkedCars = {0};
        int[] parkingSpaces = {100};
        SuperParkingBoy SuperParkingBoy = initSuperParkingBoy(1, parkedCars, parkingSpaces);
        Car car = new Car("B1");
        //when
        ParkingTicket parkingTicket = SuperParkingBoy.parkCar(car);
        //then
        assertEquals("P1-TB1", parkingTicket.getTicketNo());
    }

    @Test(expected = NoAvaliableParkingSpacesException.class)
    public void should_return_exception_When_given_one_unavailable_spaces_parking_lot() {
        //given
        int[] parkedCars = {100};
        int[] parkingSpaces = {100};
        SuperParkingBoy SuperParkingBoy = initSuperParkingBoy(1, parkedCars, parkingSpaces);
        Car car = new Car("B1");
        //when
        SuperParkingBoy.parkCar(car);
    }

    @Test
    public void should_return_ticket_When_given_two_available_spaces_parking_lots() {
        //given
        int[] parkedCars = {0, 0};
        int[] parkingSpaces = {100, 100};
        SuperParkingBoy SuperParkingBoy = initSuperParkingBoy(2, parkedCars, parkingSpaces);
        Car car = new Car("B1");
        //when
        ParkingTicket parkingTicket = SuperParkingBoy.parkCar(car);
        //then
        assertEquals("P1-TB1", parkingTicket.getTicketNo());
    }

    @Test
    public void should_return_Aticket_When_given_two_available_spaces_parking_lot_Awith_30_parkedcars_Bwith_40_parked_cars() {
        //given
        int[] parkedCars = {20, 11};
        int[] parkingSpaces = {100, 50};
        SuperParkingBoy SuperParkingBoy = initSuperParkingBoy(2, parkedCars, parkingSpaces);
        Car car = new Car("A101");
        //when
        ParkingTicket parkingTicket = SuperParkingBoy.parkCar(car);
        //then
        assertEquals("P1-TA101", parkingTicket.getTicketNo());
    }

    @Test
    public void should_return_Bticket_When_given_two_available_spaces_parking_lot_Awith_40_parkedcars_Bwith_30_parked_cars() {
        //given
        int[] parkedCars = {21, 10};
        int[] parkingSpaces = {100, 50};
        SuperParkingBoy SuperParkingBoy = initSuperParkingBoy(2, parkedCars, parkingSpaces);
        Car car = new Car("A101");
        //when
        ParkingTicket parkingTicket = SuperParkingBoy.parkCar(car);
        //then
        assertEquals("P2-TA101", parkingTicket.getTicketNo());
    }

    @Test(expected = NoAvaliableParkingSpacesException.class)
    public void should_return_exception_When_given_two_unavailable_spaces_parking_lots() {
        //given
        int[] parkedCars = {100, 100};
        int[] parkingSpaces = {100, 100};
        SuperParkingBoy SuperParkingBoy = initSuperParkingBoy(2, parkedCars, parkingSpaces);
        Car car = new Car("A101");
        //when
        SuperParkingBoy.parkCar(car);
    }

    private ParkingLot initParkCar(ParkingLot parkingLot, int parkedCar, String carName) {
        for (int i = 1; i <= parkedCar; i++) {
            Car car = new Car(carName + i);
            parkingLot.parkCar(car);
        }
        return parkingLot;
    }

    private SuperParkingBoy initSuperParkingBoy(int masteredParkingLotNum, int[] parkedCar, int[] parkingSpaces) {

        SuperParkingBoy SuperParkingBoy = new SuperParkingBoy();
        for (int i = 1; i <= masteredParkingLotNum; i++) {
            ParkingLot parkinglot = new ParkingLot("P" + i, parkingSpaces[i - 1]);
            String carName = "" + (char) ('A' + i - 1);
            initParkCar(parkinglot, parkedCar[i - 1], carName);
            SuperParkingBoy.addParkingLot(parkinglot);
        }
        return SuperParkingBoy;
    }
}
