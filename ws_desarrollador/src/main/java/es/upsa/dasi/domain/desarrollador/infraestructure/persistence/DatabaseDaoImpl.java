package es.upsa.dasi.domain.desarrollador.infraestructure.persistence;

import es.upsa.dasi.domain.desarrollador.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.util.List;

@ApplicationScoped
public class DatabaseDaoImpl implements DatabaseDao {

    @Inject
    DataSource dataSource;
    @Override
    public List<Desarrollador> findAllDesarrolladores() throws AppException {
        return null;
    }
}
