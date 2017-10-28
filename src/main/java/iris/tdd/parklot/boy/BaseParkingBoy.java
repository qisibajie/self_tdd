package iris.tdd.parklot.boy;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;
import iris.tdd.parklot.behavior.ParkBehavior;
import iris.tdd.parklot.behavior.ParkingAble;
import iris.tdd.parklot.behavior.PickUpBehavior;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BaseParkingBoy implements ParkingAble {

    Map<String, ParkingLot> parkingLots = new TreeMap<>(Comparator.naturalOrder());
    ParkBehavior parkBehavior;
    PickUpBehavior pickUpBehavior;

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.put(parkingLot.getParkingLotName(), parkingLot);
    }

    public ParkingTicket parkCar(Car car) {
        return parkBehavior.parkCar(parkingLots, car);
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        return pickUpBehavior.pickUpCar(parkingLots, parkingTicket);
    }

    public boolean hasAvailableSpaces() {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getAvailableParkingSpaces() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasSuchCar(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.hasSuchCar(parkingTicket)) {
                return true;
            }
        }
        return false;
    }
}
