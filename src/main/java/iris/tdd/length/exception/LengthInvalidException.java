package iris.tdd.length.exception;

public class LengthInvalidException extends RuntimeException {
    public LengthInvalidException(String errorMsg) {
        super(errorMsg);
    }
}
