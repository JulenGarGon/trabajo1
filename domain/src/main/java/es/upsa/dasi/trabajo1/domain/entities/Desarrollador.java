package es.upsa.dasi.trabajo1.domain.entities;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Builder(setterPrefix = "with")
@With
public record Desarrollador (int id,
                             String nombre,
                             LocalDate fundacion,
                             String fundador,
                             int empleados,
                             String sede,
                             String sitioWeb,
                             String logo
                             )
{
}
