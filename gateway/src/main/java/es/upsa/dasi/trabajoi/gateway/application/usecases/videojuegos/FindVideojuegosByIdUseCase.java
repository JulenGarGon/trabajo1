package es.upsa.dasi.trabajoi.gateway.application.usecases.videojuegos;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.Optional;

public interface FindVideojuegosByIdUseCase {
    public Optional<Videojuego> execute (int id) throws AppException;
}
