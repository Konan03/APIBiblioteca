package com.biblioteca.biblioteca.client;

import com.biblioteca.biblioteca.model.Libro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class LibroClient {

    private final RestClient restClient;

    public Libro buscarPorId(int id) {

        return restClient.get()
                .uri("/api/libros/{id}", id)
                .retrieve()
                .body(Libro.class);
    }

    public String verificarConexion() {

        return restClient.get()
                .uri("/api/libros/conexion")
                .retrieve()
                .body(String.class);
    }
}