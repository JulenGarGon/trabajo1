package es.upsa.dasi.trabajo1.domain.exceptions;

public class ConstraintViolationException extends AppException{
    public ConstraintViolationException(String message) {
        super(message);
    }
}
