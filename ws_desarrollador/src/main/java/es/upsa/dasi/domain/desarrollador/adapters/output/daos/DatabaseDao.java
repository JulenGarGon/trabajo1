package es.upsa.dasi.domain.desarrollador.adapters.output.daos;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;

public interface DatabaseDao {
    List<Desarrollador> findAllDesarrolladores() throws AppException;
}
