package es.upsa.dasi.domain.videojuego.application.impl;

import es.upsa.dasi.domain.videojuego.application.FindAllVideojuegosUseCase;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
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
