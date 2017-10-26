package ir.arp.parklot.behavior;

import ir.arp.parklot.Car;
import ir.arp.parklot.ParkingTicket;

/**
 * Created by on 10/26/2017.
 */
public interface ParkingAble {
    ParkingTicket parkCar(Car car);

    Car pickUpCar(ParkingTicket parkingTicket);

    boolean hasAvailableSpaces();

    boolean hasSuchCar(ParkingTicket parkingTicket);

    int getAllParkingSpaces();

    int getNumOfParkedCars();
}
