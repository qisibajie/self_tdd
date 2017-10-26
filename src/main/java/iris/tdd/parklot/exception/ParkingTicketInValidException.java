package iris.tdd.parklot.exception;

public class ParkingTicketInValidException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ParkingTicketInValidException(String strErrMsg) {
        super(strErrMsg);
    }

}
