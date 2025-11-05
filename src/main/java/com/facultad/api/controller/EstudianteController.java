package com.facultad.api.controller;

import com.facultad.api.dto.EstudianteDTO;
import com.facultad.api.dto.CursoDTO;
import com.facultad.api.service.estudianteService;
import com.facultad.api.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final estudianteService estudianteService;
    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<EstudianteDTO> estudiantes = estudianteService.listar();
            return ResponseEntity.ok(estudiantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar estudiantes: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EstudianteDTO dto) {
        try {
            EstudianteDTO nuevo = estudianteService.crear(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear estudiante: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<?> cursosDeEstudiante(@PathVariable Long id) {
        try {
            List<CursoDTO> cursos = cursoService.cursosDeEstudiante(id);
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al obtener cursos: " + e.getMessage());
        }
    }

    // borrador lógico
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            estudianteService.eliminarLogico(id);
            return ResponseEntity.ok("Estudiante eliminado correctamente (borrado lógico)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al eliminar estudiante: " + e.getMessage());
        }
    }
}
