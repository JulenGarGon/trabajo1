package es.upsa.dasi.trabajo1.domain.entities;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@Builder(setterPrefix = "with")
@With
public class VideojuegoDesarrollador {

    private int idVideojuego;

    @Singular("videojuegoDes")
    private List<Desarrollador> videojuegosDesarrollados;

}
