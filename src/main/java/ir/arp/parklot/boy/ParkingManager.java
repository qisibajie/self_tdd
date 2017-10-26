package ir.arp.parklot.boy;

import ir.arp.parklot.behavior.ParkingAble;
import ir.arp.parklot.exception.NoAvailableParkingSpacesException;
import ir.arp.parklot.exception.ParkingTicketInValidException;
import ir.arp.parklot.Car;
import ir.arp.parklot.ParkingTicket;

import java.util.*;

public class ParkingManager {

    private List<ParkingAble> parkingAbles = new ArrayList<>();

    void addParkingAble(ParkingAble parkingAble) {
        parkingAbles.add(parkingAble);
    }

    public ParkingTicket parkCar(Car car) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.hasAvailableSpaces()) {
                return parkingAble.parkCar(car);
            }
        }
        throw new NoAvailableParkingSpacesException("There is no available parking space");
    }

    Car pickUpCar(ParkingTicket parkingTicket) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.hasSuchCar(parkingTicket)) {
                return parkingAble.pickUpCar(parkingTicket);
            }
        }
        throw new ParkingTicketInValidException("This Ticket is invalid");
    }


    int getParkingSpaces() {
        int totalSpaces = 0;

        for (ParkingAble parkingAble : parkingAbles) {
            totalSpaces += parkingAble.getAllParkingSpaces();
        }

        return totalSpaces;
    }


    int getNumOfParkedCars() {
        int parkedCars = 0;
        for (ParkingAble parkingAble : parkingAbles) {
            parkedCars += parkingAble.getNumOfParkedCars();
        }
        return parkedCars;
    }

}
