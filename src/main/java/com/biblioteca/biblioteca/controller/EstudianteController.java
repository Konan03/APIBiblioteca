package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Estudiante;
import com.biblioteca.biblioteca.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;


    @PostMapping
    public ResponseEntity<?> crear(
            @RequestBody Estudiante estudiante) {

        Estudiante creado = estudianteService.crear(estudiante);

        if (creado == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "mensaje", "No se pudo crear el estudiante. Verifique los datos enviados."
                    ));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "mensaje", "Estudiante creado correctamente.",
                        "estudiante", creado
                ));
    }

    @GetMapping
    public ResponseEntity<?> listar() {

        List<Estudiante> estudiantes = estudianteService.listar();

        if (estudiantes.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of(
                            "mensaje", "No hay estudiantes registrados.",
                            "estudiantes", estudiantes
                    ));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensaje", "Estudiantes consultados correctamente.",
                        "estudiantes", estudiantes
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable int id) {

        Estudiante estudiante = estudianteService.buscarPorId(id);

        if (estudiante == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "mensaje", "No se encontró un estudiante con el ID " + id + "."
                    ));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensaje", "Estudiante encontrado correctamente.",
                        "estudiante", estudiante
                ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable int id,
            @RequestBody Estudiante estudiante) {

        // Primero verificamos que el estudiante exista
        Estudiante existente = estudianteService.buscarPorId(id);

        if (existente == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "mensaje", "No se encontró un estudiante con el ID " + id + "."
                    ));
        }

        Estudiante actualizado =
                estudianteService.actualizar(id, estudiante);

        if (actualizado == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "mensaje", "No se pudo actualizar el estudiante. Verifique los datos enviados."
                    ));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensaje", "Estudiante actualizado correctamente.",
                        "estudiante", actualizado
                ));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable int id) {

        boolean eliminado = estudianteService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "mensaje", "No se encontró un estudiante con el ID " + id + "."
                    ));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensaje", "Estudiante eliminado correctamente."
                ));
    }
}