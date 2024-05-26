package es.upsa.dasi.domain.videojuego.application.impl;

import es.upsa.dasi.domain.videojuego.application.UpdateVideojuegosByIdUseCase;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateVideojuegosByIdUseCaseImpl implements UpdateVideojuegosByIdUseCase {

    @Inject
    private Repository repository;
    @Override
    public Videojuego execute(Videojuego videojuego) throws AppException {
        return repository.save(videojuego);
    }
}
