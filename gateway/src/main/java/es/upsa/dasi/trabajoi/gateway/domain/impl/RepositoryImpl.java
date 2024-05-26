package es.upsa.dasi.trabajoi.gateway.domain.impl;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.DesarrolladorDao;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.VideojuegosDao;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    VideojuegosDao videojuegosDao;

    @Inject
    DesarrolladorDao desarrolladorDao;

    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        return videojuegosDao.findAllVideojuegos();
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        return videojuegosDao.findVideojuegosByIdDesarrollador(id);
    }

    @Override
    public Optional findVideojuegoById(int id) throws AppException {
        return videojuegosDao.findVideojuegoById(id);
    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {
        videojuegosDao.deleteVideojuegoById(id);
    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        return videojuegosDao.save(videojuego);
    }

    @Override
    public List<Desarrollador> findAllDesarrolladores() throws AppException {

        return desarrolladorDao.findAllDesarrolladores();
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorById(int id) throws AppException {
        return desarrolladorDao.findDesarrolladorById(id);
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException {
        return desarrolladorDao.findDesarrolladorByNombre(nombre);
    }

    @Override
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException {
        return desarrolladorDao.saveDesarrollador(desarrollador);
    }

    @Override
    public void deleteDesarrollador(int id) throws AppException {
        desarrolladorDao.deleteDesarrolladorById(id);
    }
}
