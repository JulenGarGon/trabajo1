package es.upsa.dasi.trabajo1.domain.entities;

import java.util.Date;

public record Desarrollador (int id,
                             String nombre,
                             Date fundacion,
                             String fundador,
                             int empleados,
                             String sede,
                             String sitioWeb
                             )
{
}
