package com.biblioteca.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private int id;
    private String nombre;
    private String editorial;
    private String autor;
    private String isbn;
    private String material;
    private boolean estado;
}