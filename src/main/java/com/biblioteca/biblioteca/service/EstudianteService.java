package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {

    // Los datos se almacenan temporalmente en memoria.
    private final List<Estudiante> estudiantes = new ArrayList<>();


    public Estudiante crear(Estudiante estudiante) {

        // Validamos los datos recibidos
        if (!validarEstudiante(estudiante)) {
            return null;
        }

        // No permitimos IDs repetidos
        if (buscarPorId(estudiante.getId()) != null) {
            return null;
        }

        // No permitimos códigos de estudiante repetidos
        if (existeCodigo(estudiante.getCodigoEstudiante())) {
            return null;
        }

        estudiantes.add(estudiante);

        return estudiante;
    }



    public List<Estudiante> listar() {
        return estudiantes;
    }



    public Estudiante buscarPorId(int id) {

        // Un ID válido debe ser mayor que 0
        if (id <= 0) {
            return null;
        }

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getId() == id) {
                return estudiante;
            }
        }

        return null;
    }




    public Estudiante actualizar(
            int id,
            Estudiante datosActualizados) {

        // Verificamos que los nuevos datos sean válidos
        if (!validarEstudiante(datosActualizados)) {
            return null;
        }

        // Buscamos el estudiante que queremos modificar
        Estudiante estudiante = buscarPorId(id);

        // Si no existe, no podemos actualizarlo
        if (estudiante == null) {
            return null;
        }

        // Verificamos que el nuevo código no pertenezca
        // a otro estudiante
        for (Estudiante otro : estudiantes) {

            if (otro.getId() != id &&
                    otro.getCodigoEstudiante().equals(
                            datosActualizados.getCodigoEstudiante())) {

                return null;
            }
        }


        // Atributos heredados de Usuario

        estudiante.setNombre(
                datosActualizados.getNombre()
        );

        estudiante.setTipoIdentificacion(
                datosActualizados.getTipoIdentificacion()
        );

        estudiante.setNoIdentificacion(
                datosActualizados.getNoIdentificacion()
        );

        estudiante.setEdad(
                datosActualizados.getEdad()
        );

        estudiante.setFechaNacimiento(
                datosActualizados.getFechaNacimiento()
        );

        estudiante.setGenero(
                datosActualizados.getGenero()
        );


        // Atributos propios de Estudiante

        estudiante.setCodigoEstudiante(
                datosActualizados.getCodigoEstudiante()
        );

        estudiante.setProgramaAcademico(
                datosActualizados.getProgramaAcademico()
        );

        estudiante.setSemestre(
                datosActualizados.getSemestre()
        );

        return estudiante;
    }




    public boolean eliminar(int id) {

        Estudiante estudiante = buscarPorId(id);

        // Si no existe, no hay nada que eliminar
        if (estudiante == null) {
            return false;
        }

        estudiantes.remove(estudiante);

        return true;
    }




    private boolean validarEstudiante(Estudiante estudiante) {

        // El objeto no puede ser null
        if (estudiante == null) {
            return false;
        }

        // ID mayor que cero
        if (estudiante.getId() <= 0) {
            return false;
        }

        // Nombre obligatorio
        if (estudiante.getNombre() == null ||
                estudiante.getNombre().isBlank()) {

            return false;
        }

        // Número de identificación obligatorio
        if (estudiante.getNoIdentificacion() == null ||
                estudiante.getNoIdentificacion().isBlank()) {

            return false;
        }

        // Edad válida
        if (estudiante.getEdad() <= 0) {
            return false;
        }

        // Fecha de nacimiento obligatoria
        if (estudiante.getFechaNacimiento() == null) {
            return false;
        }

        // Código de estudiante obligatorio
        if (estudiante.getCodigoEstudiante() == null ||
                estudiante.getCodigoEstudiante().isBlank()) {

            return false;
        }

        // Programa académico obligatorio
        if (estudiante.getProgramaAcademico() == null ||
                estudiante.getProgramaAcademico().isBlank()) {

            return false;
        }

        // Semestre válido
        if (estudiante.getSemestre() < 1 ||
                estudiante.getSemestre() > 10) {

            return false;
        }

        return true;
    }



    private boolean existeCodigo(String codigo) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getCodigoEstudiante().equals(codigo)) {
                return true;
            }
        }

        return false;
    }
}