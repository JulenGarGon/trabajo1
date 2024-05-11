package es.upsa.dasi.domain.desarrollador.domain;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;

public interface Repository {
    List<Desarrollador> findAllDesarrolladores() throws AppException;
}