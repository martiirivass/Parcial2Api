package com.facultad.api.mapper;
import com.facultad.api.dto.*;
import com.facultad.api.entity.*;
import java.util.stream.Collectors;

public class AppMapper {

    public static ProfesorDTO toDTO(Profesor p) {
        if (p == null) return null;
        return ProfesorDTO.builder()
                .id(p.getId()).nombre(p.getNombre()).email(p.getEmail())
                .build();
    }

    public static EstudianteDTO toDTO(Estudiante e) {
        if (e == null) return null;
        return EstudianteDTO.builder()
                .id(e.getId()).nombre(e.getNombre()).matricula(e.getMatricula())
                .build();
    }

    public static CursoDTO toDTO(Curso c) {
        if (c == null) return null;
        return CursoDTO.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .profesorId(c.getProfesor() != null ? c.getProfesor().getId() : null)
                .profesorNombre(c.getProfesor() != null ? c.getProfesor().getNombre() : null)
                .estudiantesIds(
                        c.getEstudiantes().stream().map(Estudiante::getId).collect(Collectors.toList())
                )
                .build();
    }
}
