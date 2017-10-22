package ir4.arp.parklot;

public class ParkingTicket {
    private String carNo;
    private String parkingLotName;
    private final String PREFIX_TICKET = "T";
    private final String PREFIX_PARKLOT = "-";

    public ParkingTicket(String plateNum) {
        this.carNo = plateNum;
        this.parkingLotName = "";
    }

    public ParkingTicket(String parkingLotName, String plateNum) {
        this.carNo = plateNum;
        this.parkingLotName = parkingLotName;
    }

    public String getTicketNo() {
        if (!"".equals(this.parkingLotName)) {
            return this.parkingLotName + PREFIX_PARKLOT + PREFIX_TICKET + carNo;
        } else {
            return PREFIX_TICKET + carNo;
        }

    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    @Override
    public boolean equals(Object ticket) {
        if (ticket == null) {
            return false;
        } else {
            if (ticket instanceof ParkingTicket) {
                return this.getTicketNo().equals(((ParkingTicket) ticket).getTicketNo());
            } else {
                return false;
            }
        }
    }
}
