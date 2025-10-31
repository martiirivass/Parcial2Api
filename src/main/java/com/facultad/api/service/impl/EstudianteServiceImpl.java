package com.facultad.api.service.impl;
import com.facultad.api.dto.EstudianteDTO;
import com.facultad.api.entity.Curso;
import com.facultad.api.entity.Estudiante;
import com.facultad.api.exception.NotFoundException;
import com.facultad.api.mapper.AppMapper;
import com.facultad.api.repository.CursoRepository;
import com.facultad.api.repository.EstudianteRepository;
import com.facultad.api.service.estudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service @RequiredArgsConstructor
public class EstudianteServiceImpl implements estudianteService {
    private final EstudianteRepository repo;
    private final CursoRepository cursoRepo;

    @Override
    public List<EstudianteDTO> listar() {
        return repo.findAll().stream().map(AppMapper::toDTO).collect(toList());
    }

    @Override
    public EstudianteDTO crear(EstudianteDTO dto) {
        Estudiante e = Estudiante.builder()
                .nombre(dto.getNombre())
                .matricula(dto.getMatricula())
                .build();
        e = repo.save(e);
        return AppMapper.toDTO(e);
    }

    @Override
    public List<Long> cursosIdsDeEstudiante(Long estudianteId) {
        Estudiante est = repo.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado: " + estudianteId));
        // obtener cursos por navegación inversa (si tenés mappedBy del otro lado) o consultar todos los cursos y filtrar
        return cursoRepo.findAll().stream()
                .filter(c -> c.getEstudiantes().stream().anyMatch(e -> e.getId().equals(est.getId())))
                .map(Curso::getId)
                .collect(toList());
    }
}
