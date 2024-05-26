package es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.Optional;
public interface FindDesarrolladorByNombreUseCase {

    Optional<Desarrollador> execute(String nombre) throws AppException;
}
