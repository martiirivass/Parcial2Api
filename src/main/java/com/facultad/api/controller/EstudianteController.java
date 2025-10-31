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
    public List<EstudianteDTO> listar() { return estudianteService.listar(); }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crear(@RequestBody EstudianteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.crear(dto));
    }

    @GetMapping("/{id}/cursos")
    public List<CursoDTO> cursosDeEstudiante(@PathVariable Long id) {
        return cursoService.cursosDeEstudiante(id);
    }
}
