package es.upsa.dasi.domain.videojuego.domain.impl;

import es.upsa.dasi.domain.videojuego.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    DatabaseDao dao;

    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        return dao.findAllVideojuegos();
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        return dao.findVideojuegosByIdDesarrollador(id);
    }

    @Override
    public Optional findVideojuegoById(int id) throws AppException {
        return dao.findVideojuegoById(id);
    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {
        dao.deleteVideojuegoById(id);
    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        if (videojuego.id() == 0)    return dao.save(videojuego);
        else                            return dao.updateVideojuego(videojuego);
    }
}
