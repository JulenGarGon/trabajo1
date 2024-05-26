package es.upsa.dasi.trabajoi.gateway.application.usecases.impl.desarrolladores;


import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores.FindDesarrolladorByNombreUseCase;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
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
