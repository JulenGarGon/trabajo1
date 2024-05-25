package es.upsa.dasi.trabajoi.gateway.application.usecases.impl.videojuegos;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.application.usecases.videojuegos.FindAllVideojuegosUseCase;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindAllVideojuegosUseCaseImpl implements FindAllVideojuegosUseCase {

    @Inject
    Repository repository;
    @Override
    public List<Videojuego> execute() throws AppException {
        return repository.findAllVideojuegos();
    }
}
