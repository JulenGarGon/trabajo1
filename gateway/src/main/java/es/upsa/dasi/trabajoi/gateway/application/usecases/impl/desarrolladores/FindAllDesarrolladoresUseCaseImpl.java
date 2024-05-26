package es.upsa.dasi.trabajoi.gateway.application.usecases.impl.desarrolladores;


import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores.FindAllDesarrolladoresUseCase;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
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
