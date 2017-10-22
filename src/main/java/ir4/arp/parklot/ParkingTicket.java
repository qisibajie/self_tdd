package ir4.arp.parklot;

public class ParkingTicket {
    private String carNo;
    private String parkingLotName;

    public ParkingTicket(String plateNum) {
        this.carNo = plateNum;
        this.parkingLotName = "";
    }

    public ParkingTicket(String parkingLotName, String plateNum) {
        this.carNo = plateNum;
        this.parkingLotName = parkingLotName;
    }

    public String getTicketNo() {
        final String PREFIX_TICKET = "T";
        final String PREFIX_PARKING_LOT = "-";
        if (!"".equals(this.parkingLotName)) {
            return this.parkingLotName + PREFIX_PARKING_LOT + PREFIX_TICKET + carNo;
        } else {
            return PREFIX_TICKET + carNo;
        }

    }

    public String getParkingLotName() {
        return parkingLotName;
    }
    @Override
    public boolean equals(Object ticket) {
        return ticket != null && ticket instanceof ParkingTicket && this.getTicketNo().equals(((ParkingTicket) ticket).getTicketNo());
    }
}
