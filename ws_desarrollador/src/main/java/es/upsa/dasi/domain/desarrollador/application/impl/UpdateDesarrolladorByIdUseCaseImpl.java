package es.upsa.dasi.domain.desarrollador.application.impl;

import es.upsa.dasi.domain.desarrollador.application.UpdateDesarrolladorByIdUseCase;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateDesarrolladorByIdUseCaseImpl implements UpdateDesarrolladorByIdUseCase {

    @Inject
    private Repository repository;
    @Override
    public Desarrollador execute(Desarrollador desarrollador) throws AppException {
        return repository.saveDesarrollador(desarrollador);
    }
}
