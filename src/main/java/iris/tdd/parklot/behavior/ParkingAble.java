package iris.tdd.parklot.behavior;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingTicket;

/**
 * Created by on 10/26/2017.
 */
public interface ParkingAble {
    ParkingTicket parkCar(Car car);

    Car pickUpCar(ParkingTicket parkingTicket);

    boolean hasAvailableSpaces();

    boolean hasSuchCar(ParkingTicket parkingTicket);
}
