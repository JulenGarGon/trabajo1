package es.upsa.dasi.trabajoi.gateway.application.usecases.impl.desarrolladores;

import es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores.FindDesarrolladorByIdUseCase;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FindDesarrolladorByIdUseCaseImpl implements FindDesarrolladorByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public Optional<Desarrollador> execute(int id) throws AppException {
        return repository.findDesarrolladorById(id);
    }
}
