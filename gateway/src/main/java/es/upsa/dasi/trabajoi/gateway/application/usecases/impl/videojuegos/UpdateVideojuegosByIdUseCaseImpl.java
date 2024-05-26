package es.upsa.dasi.trabajoi.gateway.application.usecases.impl.videojuegos;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.application.usecases.videojuegos.UpdateVideojuegosByIdUseCase;
import es.upsa.dasi.trabajoi.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateVideojuegosByIdUseCaseImpl implements UpdateVideojuegosByIdUseCase {

    @Inject
    private Repository repository;
    @Override
    public Videojuego execute(Videojuego videojuego) throws AppException {
        return repository.save(videojuego);
    }
}
