package es.upsa.dasi.domain.desarrollador.application.impl;

import es.upsa.dasi.domain.desarrollador.application.FindDesarrolladorByIdUseCase;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
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
