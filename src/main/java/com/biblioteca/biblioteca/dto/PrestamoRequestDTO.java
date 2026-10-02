package com.biblioteca.biblioteca.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PrestamoRequestDTO {
    private int id;
    private int idEstudiante;
    private int idLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}
