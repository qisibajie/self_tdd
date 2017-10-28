package iris.tdd.parklot.behavior.impl;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.ParkingTicket;
import iris.tdd.parklot.behavior.PickUpBehavior;
import iris.tdd.parklot.exception.ParkingTicketInValidException;

import java.util.Map;

public class NormalPickUpCar implements PickUpBehavior {

    @Override
    public Car pickUpCar(Map<String, ParkingLot> parkingLots, ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new ParkingTicketInValidException("Ticket is inviald");
        }
        ParkingLot parkingLot = parkingLots.get(parkingTicket.getParkingLotName());
        return parkingLot.pickUpCar(parkingTicket);
    }
}
