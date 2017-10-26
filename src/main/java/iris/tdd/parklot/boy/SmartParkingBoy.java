package iris.tdd.parklot.boy;

import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;
import iris.tdd.parklot.exception.NoParkingLotException;
import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingTicket;

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
