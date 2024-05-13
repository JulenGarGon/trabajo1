package es.upsa.dasi.domain.videojuego.application.impl;

import es.upsa.dasi.domain.videojuego.application.FindVideojuegosByIdDesarrollador;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class FindVideojuegosByIdDesarrolladorImpl implements FindVideojuegosByIdDesarrollador {

    @Inject
    Repository repository;

    @Override
    public List<Videojuego> executeDes(int id) throws AppException {
        return repository.findVideojuegosByIdDesarrollador(id);
    }
}
