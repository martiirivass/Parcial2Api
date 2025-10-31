package com.facultad.api.service;
import com.facultad.api.dto.EstudianteDTO;
import java.util.List;

public interface estudianteService {
    List<EstudianteDTO> listar();
    EstudianteDTO crear(EstudianteDTO dto);
    List<Long> cursosIdsDeEstudiante(Long estudianteId);
}
