package es.upsa.dasi.domain.desarrollador.domain.impl;

import es.upsa.dasi.domain.desarrollador.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
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
    public List<Desarrollador> findAllDesarrolladores() throws AppException {

        return dao.findAllDesarrolladores();
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorById(int id) throws AppException {
        return dao.findDesarrolladorById(id);
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException {
        return dao.findDesarrolladorByNombre(nombre);
    }

    @Override
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException {
        if ( desarrollador.id() == 0)   return dao.insertDesarrollador(desarrollador);
        else                            return dao.updateDesarrollador(desarrollador);
    }

    @Override
    public void deleteDesarrollador(int id) throws AppException {
        dao.deleteDesarrolladorById(id);
    }


}
