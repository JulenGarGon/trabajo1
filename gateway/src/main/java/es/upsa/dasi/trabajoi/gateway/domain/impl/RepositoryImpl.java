package es.upsa.dasi.trabajoi.gateway.domain.impl;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.VideojuegosDao;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    VideojuegosDao videojuegosDao;

    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        return videojuegosDao.findAllVideojuegos();
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        return videojuegosDao.findVideojuegosByIdDesarrollador(id);
    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {
        videojuegosDao.deleteVideojuegoById(id);
    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        return videojuegosDao.save(videojuego);
    }
}
