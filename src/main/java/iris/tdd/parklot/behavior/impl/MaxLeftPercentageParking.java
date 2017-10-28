package iris.tdd.parklot.behavior.impl;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;
import iris.tdd.parklot.behavior.ParkBehavior;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;
import iris.tdd.parklot.exception.NoParkingLotException;

import java.util.Map;

public class MaxLeftPercentageParking implements ParkBehavior {

    @Override
    public ParkingTicket parkCar(Map<String, ParkingLot> parkingLots, Car car) {
        ParkingLot parkingLot = getMaxPercentAvailableMarkLot(parkingLots);
        if (parkingLot.getAvailableParkingSpaces() == 0) {
            throw new NoAvailableParkingSpacesException("No Available Parking Spaces.");
        } else {
            return parkingLot.parkCar(car);
        }
    }

    private ParkingLot getMaxPercentAvailableMarkLot(Map<String, ParkingLot> parkingLots) {
        if (parkingLots.size() == 0) {
            throw new NoParkingLotException("There is no available parking lot");
        }
        ParkingLot maxAvailableParkingSpacesParkingLot = (ParkingLot) parkingLots.values().toArray()[0];
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getAvailablePercentSpaces().compareTo(maxAvailableParkingSpacesParkingLot.getAvailablePercentSpaces()) > 0) {
                maxAvailableParkingSpacesParkingLot = parkingLot;
            }
        }
        return maxAvailableParkingSpacesParkingLot;
    }
}
