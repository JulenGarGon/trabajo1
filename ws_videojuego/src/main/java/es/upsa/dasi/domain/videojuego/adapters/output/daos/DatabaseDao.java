package es.upsa.dasi.domain.videojuego.adapters.output.daos;

import es.upsa.dasi.domain.videojuego.adapters.input.rest.dtos.VideojuegoDto;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;
import java.util.Optional;

public interface DatabaseDao {
    List<Videojuego> findAllVideojuegos() throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException;

    Optional findVideojuegoById(int id) throws AppException;

    void deleteVideojuegoById(int id) throws AppException;

    Videojuego save(Videojuego videojuego) throws AppException;

    Videojuego updateVideojuego(Videojuego videojuego) throws AppException;
}
