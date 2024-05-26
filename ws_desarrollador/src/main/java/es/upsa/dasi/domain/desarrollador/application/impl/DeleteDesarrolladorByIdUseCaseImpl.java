package es.upsa.dasi.domain.desarrollador.application.impl;

import es.upsa.dasi.domain.desarrollador.application.DeleteDesarrolladorByIdUseCase;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteDesarrolladorByIdUseCaseImpl implements DeleteDesarrolladorByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public void execute(int id) throws AppException {
        repository.deleteDesarrollador(id);
    }
}
