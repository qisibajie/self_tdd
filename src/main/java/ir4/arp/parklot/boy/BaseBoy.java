package ir4.arp.parklot.boy;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import ir4.arp.parklot.Car;
import ir4.arp.parklot.ParkingLot;
import ir4.arp.parklot.ParkingTicket;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

public abstract class BaseBoy {

    protected Map<String, ParkingLot> parkingLots = new TreeMap<String, ParkingLot>(new Comparator<String>() {
        public int compare(String firstStr, String secondKey) {
            return firstStr.compareTo(secondKey);
        }
    });


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

    public abstract ParkingTicket parkCar(Car car);
}
