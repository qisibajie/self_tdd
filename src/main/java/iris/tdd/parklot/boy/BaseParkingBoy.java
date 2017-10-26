package iris.tdd.parklot.boy;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.behavior.ParkingAble;
import iris.tdd.parklot.exception.ParkingTicketInValidException;
import iris.tdd.parklot.ParkingTicket;

public abstract class BaseParkingBoy implements ParkingAble {

    Map<String, ParkingLot> parkingLots = new TreeMap<>(Comparator.naturalOrder());


    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.put(parkingLot.getParkingLotName(), parkingLot);
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new ParkingTicketInValidException("Ticket is inviald");
        }
        ParkingLot parkingLot = parkingLots.get(parkingTicket.getParkingLotName());
        return parkingLot.pickUpCar(parkingTicket);
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

    @Override
    public int getAllParkingSpaces() {
        int allSpaces = 0;
        for (ParkingLot parkingLot : parkingLots.values()) {
            allSpaces += parkingLot.getAllParkingSpaces();
        }
        return allSpaces;
    }

    @Override
    public int getNumOfParkedCars() {
        int parkedCars = 0;
        for (ParkingLot parkingLot : parkingLots.values()) {
            parkedCars += parkingLot.getNumOfParkedCars();
        }
        return parkedCars;
    }

    public abstract ParkingTicket parkCar(Car car);
}
