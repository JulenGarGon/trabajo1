package es.upsa.dasi.trabajoi.gateway.domain;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;
import java.util.Optional;

public interface Repository {

    //VIDEOJUEGOS

    List<Videojuego> findAllVideojuegos() throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException;

    Optional findVideojuegoById(int id) throws AppException;

    void deleteVideojuegoById(int id) throws AppException;

    Videojuego save(Videojuego videojuego) throws AppException;

    //DESARROLLADORES

    List<Desarrollador> findAllDesarrolladores() throws AppException;

    Optional<Desarrollador> findDesarrolladorById(int id) throws AppException;

    Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException;

    Desarrollador saveDesarrollador (Desarrollador desarrollador) throws AppException;

    void deleteDesarrollador(int id) throws AppException;
}
