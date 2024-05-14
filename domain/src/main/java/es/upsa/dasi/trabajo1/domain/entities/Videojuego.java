package es.upsa.dasi.trabajo1.domain.entities;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@Builder(setterPrefix = "with")
@With
public record Videojuego(int id,
                         String nombre,
                         String genero,
                         LocalDate estreno,
                         String portada,
                         float duracion,
                         float tamanio,
                         int ventas,
                         int desarrollador,
                         float nota
                         )
{
}
