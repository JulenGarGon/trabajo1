package es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

public interface InsertDesarrolladorUseCase {
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException;
}
