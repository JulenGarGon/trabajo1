package es.upsa.dasi.domain.desarrollador.application.impl;

import es.upsa.dasi.domain.desarrollador.application.InsertDesarrolladorUseCase;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsertDesarrolladorUseCaseImpl implements InsertDesarrolladorUseCase {

    @Inject
    Repository repository;
    @Override
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException {
        return repository.saveDesarrollador(desarrollador);
    }
}
