package com.facultad.api.controller;

import com.facultad.api.dto.CursoDTO;
import com.facultad.api.dto.CreateCursoRequest;
import com.facultad.api.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<?> listarCursos() {
        try {
            List<CursoDTO> cursos = cursoService.listar();
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar cursos: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody CreateCursoRequest req) {
        try {
            CursoDTO cursoCreado = cursoService.crear(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear curso: " + e.getMessage());
        }
    }

    @PostMapping("/{cursoId}/agregar-estudiante/{estudianteId}")
    public ResponseEntity<?> asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        try {
            CursoDTO actualizado = cursoService.asignarEstudiante(cursoId, estudianteId);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al asignar estudiante: " + e.getMessage());
        }
    }

    @GetMapping("/por-estudiante/{estudianteId}")
    public ResponseEntity<?> cursosPorEstudiante(@PathVariable Long estudianteId) {
        try {
            return ResponseEntity.ok(cursoService.cursosDeEstudiante(estudianteId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al obtener cursos del estudiante: " + e.getMessage());
        }
    }

    // borradoe lógico
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id) {
        try {
            cursoService.eliminarLogico(id);
            return ResponseEntity.ok("Curso eliminado correctamente (borrado lógico)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al eliminar curso: " + e.getMessage());
        }
    }
}
