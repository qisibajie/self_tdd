package iris.tdd.parklot.boy;

import iris.tdd.parklot.behavior.ParkingAble;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;
import iris.tdd.parklot.exception.ParkingTicketInValidException;
import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingTicket;

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
}
