package es.upsa.dasi.domain.desarrollador.application.impl;

import es.upsa.dasi.domain.desarrollador.application.FindAllDesarrolladoresUseCase;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindAllDesarrolladoresUseCaseImpl implements FindAllDesarrolladoresUseCase {

    @Inject
    Repository repository;
    @Override
    public List<Desarrollador> execute() throws AppException {
        return repository.findAllDesarrolladores();
    }
}
