package iris.tdd.parklot.exception;

public class NoAvailableParkingSpacesException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NoAvailableParkingSpacesException(String strErrMsg) {
        super(strErrMsg);
    }

}

