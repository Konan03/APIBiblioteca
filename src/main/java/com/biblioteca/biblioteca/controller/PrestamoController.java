package com.biblioteca.biblioteca.controller;


import com.biblioteca.biblioteca.dto.PrestamoRequestDTO;
import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;


    // CREATE
    // POST /api/prestamos
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PrestamoRequestDTO request) {

        Prestamo prestamo = prestamoService.crear(request);

        if (prestamo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Estudiante no encontrado");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(prestamo);
    }


    // READ
    // GET /api/prestamos
    @GetMapping
    public ResponseEntity<List<Prestamo>> listar() {

        return ResponseEntity.ok(prestamoService.listar());
    }


    // READ BY ID
    // GET /api/prestamos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {

        Prestamo prestamo = prestamoService.buscarPorId(id);

        if (prestamo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Préstamo no encontrado");
        }

        return ResponseEntity.ok(prestamo);
    }


    // DELETE
    // DELETE /api/prestamos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {

        boolean eliminado = prestamoService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Préstamo no encontrado");
        }

        return ResponseEntity.ok("Préstamo eliminado correctamente");
    }
}