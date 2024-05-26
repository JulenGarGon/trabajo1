package es.upsa.dasi.domain.desarrollador.adapters.input.rest.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DesarrolladorDto {

    private int id;
    private String nombre;
    private LocalDate fundacion;
    private String fundador;
    private int empleados;
    private String sede;
    private String sitioWeb;
    private String logo;
}
