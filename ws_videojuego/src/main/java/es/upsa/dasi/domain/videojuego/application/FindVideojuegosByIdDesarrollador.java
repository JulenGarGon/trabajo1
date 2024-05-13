package es.upsa.dasi.domain.videojuego.application;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;
import java.util.Optional;

public interface FindVideojuegosByIdDesarrollador {
    List<Videojuego> executeDes (int id) throws AppException;
}
