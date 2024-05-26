package es.upsa.dasi.domain.desarrollador.domain;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;
import java.util.Optional;

public interface Repository {
    List<Desarrollador> findAllDesarrolladores() throws AppException;

    Optional<Desarrollador> findDesarrolladorById(int id) throws AppException;

    Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException;

    Desarrollador saveDesarrollador (Desarrollador desarrollador) throws AppException;

    void deleteDesarrollador(int id) throws AppException;
}
