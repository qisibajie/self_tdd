package ir4.arp.parklot.boy;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.exception.NoAvailableParkingSpacesException;

public class ParkingBoy extends BaseBoy {


    public ParkingTicket parkCar(Car car) {
        boolean isExistedAvailableParkingSpaces = false;
        ParkingTicket parkingTicket = null;
        for (String key : parkingLots.keySet()) {
            if (parkingLots.get(key).getCurrentParkingSpaces() > 0) {
                isExistedAvailableParkingSpaces = true;
                parkingTicket = parkingLots.get(key).parkCar(car);
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
