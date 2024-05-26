package es.upsa.dasi.domain.desarrollador.application;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

public interface UpdateDesarrolladorByIdUseCase {
    public Desarrollador execute(Desarrollador desarrollador) throws AppException;
}
