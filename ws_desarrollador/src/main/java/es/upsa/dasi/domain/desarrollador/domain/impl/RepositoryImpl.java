package es.upsa.dasi.domain.desarrollador.domain.impl;

import es.upsa.dasi.domain.desarrollador.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.domain.desarrollador.domain.Repository;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    DatabaseDao dao;
    @Override
    public List<Desarrollador> findAllDesarrolladores() throws AppException {

        return dao.findAllDesarrolladores();
    }
}
