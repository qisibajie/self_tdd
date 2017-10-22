package ir4.arp.parklot.boy;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.exception.NoAvailableParkingSpacesException;
import ir4.arp.parklot.exception.NoParkingLotException;

public class SuperParkingBoy extends BaseBoy {

    @Override
    public ParkingTicket parkCar(Car car) {
        ParkingLot parkingLot = getMaxPercentAvailableMarkLot();
        if (parkingLot.getCurrentParkingSpaces() == 0) {
            throw new NoAvailableParkingSpacesException("No Available Parking Spaces.");
        } else {
            return parkingLot.parkCar(car);
        }
    }


    private ParkingLot getMaxPercentAvailableMarkLot() {
        if (parkingLots.size() == 0) {
            throw new NoParkingLotException("There is no available parking lot");
        }
        ParkingLot maxAvailableParkingSpacesParkingLot = (ParkingLot) parkingLots.values().toArray()[0];
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getAvailablePercentSpaces(parkingLot).compareTo(parkingLot.getAvailablePercentSpaces(maxAvailableParkingSpacesParkingLot)) > 0) {
                maxAvailableParkingSpacesParkingLot = parkingLot;
            }
        }
        return maxAvailableParkingSpacesParkingLot;
    }

}
