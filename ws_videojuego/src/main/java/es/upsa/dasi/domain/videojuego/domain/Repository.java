package es.upsa.dasi.domain.videojuego.domain;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;
import java.util.Optional;

public interface Repository {
    List<Videojuego> findAllVideojuegos() throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException;
}
