package es.upsa.dasi.domain.videojuego.application.impl;

import es.upsa.dasi.domain.videojuego.application.FindVideojuegoByIdUseCase;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
@ApplicationScoped
public class FindVideojuegoByIdUseCaseImpl implements FindVideojuegoByIdUseCase {

    @Inject
    Repository repository;
    @Override
    public Optional<Videojuego> execute(int id) throws AppException {
        return repository.findVideojuegoById(id);
    }
}
