package ir4.arp.parklot;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ir4.arp.parklot.exception.NoAvailableParkingSpacesException;
import ir4.arp.parklot.exception.ParkingTicketInValidException;

public class ParkingLot {

    private Map<ParkingTicket, Car> mapCarsTickets = new HashMap<>();
    private int curr_avil_count = 100;
    private String parkingLotName;

    private void addSpace() {
        curr_avil_count++;
    }

    private void reduceSpace() {
        curr_avil_count--;
    }

    private int getParkingLotSpacesTotal() {
        return this.curr_avil_count + mapCarsTickets.size();
    }


    public BigDecimal getAvailablePercentSpaces(ParkingLot parkingLot) {
        return new BigDecimal(parkingLot.getCurrentParkingSpaces()).divide(new BigDecimal(parkingLot.getParkingLotSpacesTotal()), 2);
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public ParkingLot(String name, int count) {
        curr_avil_count = count;
        parkingLotName = name;
    }

    public int getCurrentParkingSpaces() {
        return curr_avil_count;
    }

    public ParkingTicket parkCar(Car car) {
        if (curr_avil_count <= 0) {
            throw new NoAvailableParkingSpacesException("There is no available parking space");
        }
        ParkingTicket parkingTicket = new ParkingTicket(this.parkingLotName, car.getPlateNum());
        mapCarsTickets.put(parkingTicket, car);
        reduceSpace();
        return parkingTicket;
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        ParkingTicket ticket = getParkingTicket(parkingTicket);
        if (ticket == null) {
            throw new ParkingTicketInValidException("Parking Ticket is invalid");
        }
        Car car = mapCarsTickets.remove(ticket);
        addSpace();
        return car;
    }

    private ParkingTicket getParkingTicket(ParkingTicket parkingTicket) {
        for (ParkingTicket ticket : mapCarsTickets.keySet()) {
            if (ticket.equals(parkingTicket)) {
                return ticket;
            }
        }
        return null;
    }
}
