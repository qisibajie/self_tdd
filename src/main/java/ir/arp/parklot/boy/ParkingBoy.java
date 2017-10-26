package ir.arp.parklot.boy;

import ir.arp.parklot.Car;
import ir.arp.parklot.ParkingTicket;
import ir.arp.parklot.exception.NoAvailableParkingSpacesException;

public class ParkingBoy extends BaseParkingBoy {


    public ParkingTicket parkCar(Car car) {
        boolean isExistedAvailableParkingSpaces = false;
        ParkingTicket parkingTicket = null;
        for (String key : parkingLots.keySet()) {
            if (parkingLots.get(key).getAvailableParkingSpaces() > 0) {
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
