package es.upsa.dasi.domain.desarrollador.application;

import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

public interface DeleteDesarrolladorByIdUseCase {
    void execute(int id) throws AppException;
}
