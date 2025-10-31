package com.facultad.api.service.impl;
import com.facultad.api.dto.*;
import com.facultad.api.entity.*;
import com.facultad.api.exception.NotFoundException;
import com.facultad.api.mapper.AppMapper;
import com.facultad.api.repository.*;
import com.facultad.api.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service @RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepo;
    private final ProfesorRepository profesorRepo;
    private final EstudianteRepository estudianteRepo;

    @Override
    public List<CursoDTO> listar() {
        return cursoRepo.findAll().stream().map(AppMapper::toDTO).collect(toList());
    }

    @Override
    @Transactional
    public CursoDTO crear(CreateCursoRequest req) {
        Profesor prof = profesorRepo.findById(req.getProfesorId())
                .orElseThrow(() -> new NotFoundException("Profesor no encontrado: " + req.getProfesorId()));

        Curso c = Curso.builder()
                .nombre(req.getNombre())
                .profesor(prof)
                .build();

        c = cursoRepo.save(c);
        return AppMapper.toDTO(c);
    }

    @Override
    @Transactional
    public CursoDTO asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso c = cursoRepo.findById(cursoId)
                .orElseThrow(() -> new NotFoundException("Curso no encontrado: " + cursoId));
        Estudiante e = estudianteRepo.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado: " + estudianteId));

        c.getEstudiantes().add(e);
        // no hace falta save explícito si la entidad está en contexto, pero lo dejamos claro
        c = cursoRepo.save(c);
        return AppMapper.toDTO(c);
    }

    @Override
    public List<CursoDTO> cursosDeEstudiante(Long estudianteId) {
        estudianteRepo.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado: " + estudianteId));
        return cursoRepo.findAll().stream()
                .filter(c -> c.getEstudiantes().stream().anyMatch(e -> e.getId().equals(estudianteId)))
                .map(AppMapper::toDTO)
                .collect(toList());
    }
}
