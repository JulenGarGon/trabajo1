package es.upsa.dasi.trabajoi.gateway.domain.impl;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.DesarrolladorDao;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.VideojuegoDao;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    VideojuegoDao videojuegoDao;

    @Inject
    DesarrolladorDao desarrolladorDao;

    //VIDEOJUEGOS

    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        return videojuegoDao.findAllVideojuegos();
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        return videojuegoDao.findVideojuegosByIdDesarrollador(id);
    }

    @Override
    public Optional findVideojuegoById(int id) throws AppException {
        return videojuegoDao.findVideojuegoById(id);
    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {
        videojuegoDao.deleteVideojuegoById(id);
    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        if (videojuego.id() == 0)   return videojuegoDao.save(videojuego);
        else                        return videojuegoDao.updateVideojuego(videojuego);
    }

    //DESARROLLADORES

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
