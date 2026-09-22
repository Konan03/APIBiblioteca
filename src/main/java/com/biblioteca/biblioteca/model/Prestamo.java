package com.biblioteca.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {

    private int id;
    private LocalDate fechaPrestamo;
    private Estudiante estudiante;
    private LocalDate fechaDevolucion;
    private Libro libro;
}