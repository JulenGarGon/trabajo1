package es.upsa.dasi.domain.desarrollador.application.impl;

import es.upsa.dasi.domain.desarrollador.application.FindDesarrolladorByNombreUseCase;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
@ApplicationScoped
public class FindDesarrolladorByNombreUseCaseImpl implements FindDesarrolladorByNombreUseCase {

    @Inject
    Repository repository;
    @Override
    public Optional<Desarrollador> execute(String nombre) throws AppException {
        return repository.findDesarrolladorByNombre(nombre);
    }
}
