package ir.arp.parklot.boy;

import ir.arp.parklot.ParkingLot;
import ir.arp.parklot.exception.NoAvailableParkingSpacesException;
import ir.arp.parklot.exception.NoParkingLotException;
import ir.arp.parklot.Car;
import ir.arp.parklot.ParkingTicket;

public class SmartParkingBoy extends BaseParkingBoy {

	@Override
	public ParkingTicket parkCar(Car car) {
		ParkingLot parkingLot = getMaxAvailableMarkLot();
		if (parkingLot.getAvailableParkingSpaces() == 0) {
			throw new NoAvailableParkingSpacesException("No Available Parking Spaces.");
		} else {
			return parkingLot.parkCar(car);
		}
	}


	private ParkingLot getMaxAvailableMarkLot() {

		if (parkingLots.size() == 0) {
			throw new NoParkingLotException("There is no available parking lot");
		}
		ParkingLot maxAvailableParkingSpacesParkingLot = (ParkingLot) parkingLots.values().toArray()[0];
		for (ParkingLot parkingLot : parkingLots.values()) {
			if (parkingLot.getAvailableParkingSpaces() > maxAvailableParkingSpacesParkingLot.getAvailableParkingSpaces()) {
				maxAvailableParkingSpacesParkingLot = parkingLot;
			}
		}
		return maxAvailableParkingSpacesParkingLot;
	}
}
