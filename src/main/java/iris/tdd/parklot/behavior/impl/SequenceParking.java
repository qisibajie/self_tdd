package iris.tdd.parklot.behavior.impl;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;
import iris.tdd.parklot.behavior.ParkBehavior;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SequenceParking implements ParkBehavior {

    @Override
    public ParkingTicket parkCar(Map<String, ParkingLot> parkingLots, Car car) {
        boolean isExistedAvailableParkingSpaces = false;
        ParkingTicket parkingTicket = null;
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getAvailableParkingSpaces() > 0) {
                isExistedAvailableParkingSpaces = true;
                parkingTicket = parkingLot.parkCar(car);
                break;
            }
        }
        if (!isExistedAvailableParkingSpaces) {
            throw new NoAvailableParkingSpacesException("No Available Parking Spaces.");
        } else {
            return parkingTicket;
        }
    }
}
