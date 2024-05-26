package es.upsa.dasi.trabajoi.gateway.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
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
