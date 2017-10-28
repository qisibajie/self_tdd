package iris.tdd.parklot.boy;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;

public class ParkingBoy extends BaseParkingBoy {


    public ParkingTicket parkCar(Car car) {
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
