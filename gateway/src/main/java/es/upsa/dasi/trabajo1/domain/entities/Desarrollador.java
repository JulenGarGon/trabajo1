package es.upsa.dasi.trabajo1.domain.entities;

import lombok.Builder;
import lombok.With;

import java.util.Date;

@Builder(setterPrefix = "with")
@With
public record Desarrollador (int id,
                             String nombre,
                             Date fundacion,
                             String fundador,
                             int empleados,
                             String sede,
                             String sitioWeb,
                             String logo
                             )
{
}
