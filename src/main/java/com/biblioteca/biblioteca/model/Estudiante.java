package com.biblioteca.biblioteca.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// Genera los getters de los atributos declarados en Estudiante.
// getCodigoEstudiante()
// getProgramaAcademico()
// getSemestre()
//
// Los getters de Usuario se HEREDAN.
@Getter

// Genera los setters de los atributos declarados en Estudiante.
//
// Los setters públicos de Usuario también se HEREDAN.
@Setter

// Genera un constructor vacío:
//
// public Estudiante() {
//     super();
// }
//
// AQUÍ ESTÁ LA PARTE IMPORTANTE:
// aunque Lombok genere el constructor,
// Java debe llamar primero al constructor de Usuario.
//
// Como no especificamos cuál, se llama automáticamente:
// super();
//
// Y eso funciona porque Usuario tiene @NoArgsConstructor.
@NoArgsConstructor

// Genera el toString() de Estudiante.
//
// callSuper = true le dice a Lombok que también
// incluya el toString() de la clase padre (Usuario).
@ToString(callSuper = true)

public class Estudiante extends Usuario {

    private String codigoEstudiante;
    private String programaAcademico;
    private int semestre;
}