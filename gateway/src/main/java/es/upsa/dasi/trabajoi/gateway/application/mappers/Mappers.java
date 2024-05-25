package es.upsa.dasi.trabajoi.gateway.application.mappers;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajoi.gateway.application.dtos.VideojuegoDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.Function;

@ApplicationScoped
public class Mappers {

    public Function<Videojuego, VideojuegoDto> mapToVideojuegoDto = videojuego -> VideojuegoDto.builder()
                                                                                                .withId(videojuego.id())
                                                                                                .withNombre(videojuego.nombre())
                                                                                                .withGenero(videojuego.genero())
                                                                                                .withEstreno(videojuego.estreno())
                                                                                                .withPortada(videojuego.portada())
                                                                                                .withDuracion(videojuego.duracion())
                                                                                                .withTamanio(videojuego.tamanio())
                                                                                                .withVentas(videojuego.ventas())
                                                                                                .withDesarrollador(videojuego.desarrollador())
                                                                                                .withNota(videojuego.nota())
                                                                                                .build();
}
