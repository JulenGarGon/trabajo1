package es.upsa.dasi.trabajoi.gateway.application.usecases.impl.desarrolladores;


import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores.DeleteDesarrolladorByIdUseCase;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
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
