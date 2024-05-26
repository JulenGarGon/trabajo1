package es.upsa.dasi.trabajoi.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;

public interface FindAllDesarrolladoresUseCase {
    List<Desarrollador> execute() throws AppException;
}
