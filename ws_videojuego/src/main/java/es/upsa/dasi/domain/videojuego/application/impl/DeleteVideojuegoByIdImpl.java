package es.upsa.dasi.domain.videojuego.application.impl;

import es.upsa.dasi.domain.videojuego.application.DeleteVideojuegoById;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteVideojuegoByIdImpl implements DeleteVideojuegoById {

    @Inject
    Repository repository;

    @Override
    public void execute(int id) throws AppException {
        repository.deleteVideojuegoById(id);
    }
}
