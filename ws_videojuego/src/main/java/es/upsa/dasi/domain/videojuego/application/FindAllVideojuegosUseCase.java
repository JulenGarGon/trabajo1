package es.upsa.dasi.domain.videojuego.application;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;

public interface FindAllVideojuegosUseCase {
    List<Videojuego> execute() throws AppException;
}
