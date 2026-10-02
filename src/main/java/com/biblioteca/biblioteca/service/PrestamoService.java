package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.client.LibroClient;
import com.biblioteca.biblioteca.dto.PrestamoRequestDTO;
import com.biblioteca.biblioteca.model.Estudiante;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.model.Prestamo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final List<Prestamo> prestamos = new ArrayList<>();

    private final EstudianteService estudianteService;
    private final LibroClient libroClient;


    // CREATE
    public Prestamo crear(PrestamoRequestDTO request) {

        // El estudiante está en esta API
        Estudiante estudiante =
                estudianteService.buscarPorId(request.getIdEstudiante());

        if (estudiante == null) {
            return null;
        }


        // El libro está en APILibros
        Libro libro =
                libroClient.buscarPorId(request.getIdLibro());


        Prestamo prestamo = new Prestamo(
                request.getId(),
                request.getFechaPrestamo(),
                estudiante,
                request.getFechaDevolucion(),
                libro
        );

        prestamos.add(prestamo);

        return prestamo;
    }


    // READ
    public List<Prestamo> listar() {
        return prestamos;
    }


    // READ BY ID
    public Prestamo buscarPorId(int id) {

        for (Prestamo prestamo : prestamos) {

            if (prestamo.getId() == id) {
                return prestamo;
            }
        }

        return null;
    }


    // DELETE
    public boolean eliminar(int id) {

        Prestamo prestamo = buscarPorId(id);

        if (prestamo == null) {
            return false;
        }

        prestamos.remove(prestamo);

        return true;
    }
}