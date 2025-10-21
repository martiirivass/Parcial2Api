package com.facultad.api.controller;

import com.facultad.api.entity.*;
import com.facultad.api.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository cursoRepo;
    private final ProfesorRepository profesorRepo;
    private final EstudianteRepository estudianteRepo;

    public CursoController(CursoRepository cursoRepo, ProfesorRepository profesorRepo, EstudianteRepository estudianteRepo) {
        this.cursoRepo = cursoRepo;
        this.profesorRepo = profesorRepo;
        this.estudianteRepo = estudianteRepo;
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoRepo.findAll();
    }

    @PostMapping
    public Curso crearCurso(@RequestParam String nombre, @RequestParam Long profesorId) {
        Profesor prof = profesorRepo.findById(profesorId).orElseThrow();
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setProfesor(prof);
        return cursoRepo.save(curso);
    }

    @PostMapping("/{cursoId}/agregar-estudiante/{estudianteId}")
    public Curso asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();
        Estudiante est = estudianteRepo.findById(estudianteId).orElseThrow();
        curso.getEstudiantes().add(est);
        return cursoRepo.save(curso);
    }

    @GetMapping("/por-estudiante/{estudianteId}")
    public List<Curso> cursosPorEstudiante(@PathVariable Long estudianteId) {
        Estudiante est = estudianteRepo.findById(estudianteId).orElseThrow();
        return est.getCursos();
    }
}
