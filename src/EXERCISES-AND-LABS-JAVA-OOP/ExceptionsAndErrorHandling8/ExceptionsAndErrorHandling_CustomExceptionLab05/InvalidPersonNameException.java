package ExceptionsAndErrorHandling8.ExceptionsAndErrorHandling_CustomExceptionLab05;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
