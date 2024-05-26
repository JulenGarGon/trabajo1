package es.upsa.dasi.trabajoi.gateway.application.mappers;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajoi.gateway.application.dtos.DesarrolladorDto;
import es.upsa.dasi.trabajoi.gateway.application.dtos.VideojuegoDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.BiFunction;
import java.util.function.Function;

@ApplicationScoped
public class Mappers {

    public Function<Videojuego, VideojuegoDto> mapToVideojuegoDto = videojuego -> VideojuegoDto.builder()
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

    public Function<VideojuegoDto, Videojuego> mapToVideojuego = videojuegoDto -> Videojuego.builder()
                                                                                                .withNombre(videojuegoDto.getNombre())
                                                                                                .withGenero(videojuegoDto.getGenero())
                                                                                                .withEstreno(videojuegoDto.getEstreno())
                                                                                                .withPortada(videojuegoDto.getPortada())
                                                                                                .withDuracion(videojuegoDto.getDuracion())
                                                                                                .withTamanio(videojuegoDto.getTamanio())
                                                                                                .withVentas(videojuegoDto.getVentas())
                                                                                                .withDesarrollador(videojuegoDto.getDesarrollador())
                                                                                                .withNota(videojuegoDto.getNota())
                                                                                                .build();

    public BiFunction<Integer, VideojuegoDto, Videojuego> toVideojuego = (idVideojuego, videojuegoDto) -> Videojuego.builder()
                                                                                                                    .withId(idVideojuego)
                                                                                                                    .withNombre(videojuegoDto.getNombre())
                                                                                                                    .withGenero(videojuegoDto.getGenero())
                                                                                                                    .withEstreno(videojuegoDto.getEstreno())
                                                                                                                    .withPortada(videojuegoDto.getPortada())
                                                                                                                    .withDuracion(videojuegoDto.getDuracion())
                                                                                                                    .withTamanio(videojuegoDto.getTamanio())
                                                                                                                    .withVentas(videojuegoDto.getVentas())
                                                                                                                    .withDesarrollador(videojuegoDto.getDesarrollador())
                                                                                                                    .withNota(videojuegoDto.getNota())
                                                                                                                    .build();

    public Function<Desarrollador, DesarrolladorDto> mapToDesarrolladorDto = desarrollador -> DesarrolladorDto.builder()
                                                                                                                .withNombre(desarrollador.nombre())
                                                                                                                .withFundacion(desarrollador.fundacion())
                                                                                                                .withFundador(desarrollador.fundador())
                                                                                                                .withEmpleados(desarrollador.empleados())
                                                                                                                .withSede(desarrollador.sede())
                                                                                                                .withSitioWeb(desarrollador.sitioWeb())
                                                                                                                .withLogo(desarrollador.logo())
                                                                                                                .build();


}
