package es.upsa.dasi.trabajo1.domain.exceptions;

public class EntityNotFoundException extends AppException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
