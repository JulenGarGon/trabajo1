package es.upsa.dasi.trabajoi.gateway.application.usecases.videojuegos;

import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

public interface DeleteVideojuegoByIdUseCase {

    void execute(int id) throws AppException;
}
