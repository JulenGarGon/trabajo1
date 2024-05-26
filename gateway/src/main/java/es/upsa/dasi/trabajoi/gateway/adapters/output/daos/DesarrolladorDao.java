package es.upsa.dasi.trabajoi.gateway.adapters.output.daos;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;
import java.util.Optional;

public interface DesarrolladorDao {

    List<Desarrollador> findAllDesarrolladores() throws AppException;

    Optional<Desarrollador> findDesarrolladorById(int id) throws AppException;

    Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException;

    Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException;

    void deleteDesarrolladorById(int id) throws AppException;
}
