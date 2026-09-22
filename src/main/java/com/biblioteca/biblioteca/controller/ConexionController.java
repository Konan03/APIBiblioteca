package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.client.LibroClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conexion")
@RequiredArgsConstructor
public class ConexionController {

    private final LibroClient libroClient;

    @GetMapping("/libros")
    public ResponseEntity<String> conexionLibros() {

        try {

            String respuesta = libroClient.verificarConexion();

            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("APILibros no disponible");
        }
    }
}