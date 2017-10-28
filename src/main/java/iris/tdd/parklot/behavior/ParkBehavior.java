package iris.tdd.parklot.behavior;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;

import java.util.Map;

public interface ParkBehavior {
    ParkingTicket parkCar(Map<String, ParkingLot> parkingLots, Car car);
}
