package es.upsa.dasi.domain.videojuego.application;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

public interface UpdateVideojuegosByIdUseCase {
    public Videojuego execute(Videojuego videojuego) throws AppException;
}
