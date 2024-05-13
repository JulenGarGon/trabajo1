package es.upsa.dasi.domain.videojuego.domain.impl;

import es.upsa.dasi.domain.videojuego.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    DatabaseDao dao;

    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        return dao.findAllVideojuegos();
    }
}
