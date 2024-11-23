package cami.bootcamp.model.exception;

public class BadBookingRequestException extends Exception {
    public BadBookingRequestException(String message) {
        super(message);
    }
}
