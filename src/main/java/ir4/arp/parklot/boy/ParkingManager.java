package ir4.arp.parklot.boy;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.exception.NoAvaliableParkingSpacesException;

public class ParkingManager extends BaseBoy {

    @Override
    public ParkingTicket parkCar(Car car) {
        boolean isExistedAvaliableParkingSpaces = false;
        ParkingTicket parkingTicket = null;
        for (String key : parkingLots.keySet()) {
            if (parkingLots.get(key).getCurrentParkingSpaces() > 0) {
                isExistedAvaliableParkingSpaces = true;
                parkingTicket = parkingLots.get(key).parkCar(car);
                break;
            }
        }
        if (!isExistedAvaliableParkingSpaces) {
            throw new NoAvaliableParkingSpacesException("No Available Parking Spaces.");
        } else {
            return parkingTicket;
        }
    }


    public void addParkingBoy(BaseBoy baseParkingBoy) {
    }
}
