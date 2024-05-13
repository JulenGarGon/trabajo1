package es.upsa.dasi.domain.videojuego.adapters.output.daos;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

import java.util.List;

public interface DatabaseDao {
    List<Videojuego> findAllVideojuegos() throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException;

    void deleteVideojuegoById(int id) throws AppException;
}
