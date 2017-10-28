package iris.tdd.parklot.behavior;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;

import java.util.Map;

public interface PickUpBehavior {
    Car pickUpCar(Map<String, ParkingLot> parkingLots, ParkingTicket parkingTicket);
}
