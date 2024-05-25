package es.upsa.dasi.trabajoi.gateway.application.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VideojuegoDto {
    private int id;
    private String nombre;
    private String genero;
    private LocalDate estreno;
    private String portada;
    private float duracion;
    private float tamanio;
    private int ventas;
    private int desarrollador;
    private float nota;
}
