package com.biblioteca.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


// Genera automáticamente todos los métodos get.
// Ejemplo: getId(), getNombre(), getEdad()...
@Getter

// Genera automáticamente todos los métodos set.
// Ejemplo: setId(), setNombre(), setEdad()...
@Setter

// Genera un constructor SIN parámetros:
//
// public Usuario() {
// }
//
// Este constructor será importante para entender
// qué ocurre cuando Estudiante se construye.
@NoArgsConstructor

// Genera un constructor con TODOS los atributos
// que están declarados directamente en Usuario:
//
// public Usuario(int id,
//                String nombre,
//                String tipoIdentificacion,
//                String noIdentificacion,
//                int edad,
//                LocalDate fechaNacimiento,
//                String genero) {
//     this.id = id;
//     this.nombre = nombre;
//     ...
// }
@AllArgsConstructor

// Genera automáticamente el método toString().
// Permite imprimir los atributos del objeto.
@ToString

public abstract class Usuario {

    private int id;
    private String nombre;
    private String tipoIdentificacion;
    private String noIdentificacion;
    private int edad;
    private LocalDate fechaNacimiento;
    private String genero;
}