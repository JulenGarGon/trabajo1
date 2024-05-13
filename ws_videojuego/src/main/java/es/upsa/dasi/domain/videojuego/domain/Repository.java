package es.upsa.dasi.domain.videojuego.domain;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;

public interface Repository {
    List<Videojuego> findAllVideojuegos() throws AppException;
}
