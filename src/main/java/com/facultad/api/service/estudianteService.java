package com.facultad.api.service;

import com.facultad.api.dto.EstudianteDTO;
import java.util.List;

public interface EstudianteService {
    List<EstudianteDTO> listar();
    EstudianteDTO crear(EstudianteDTO dto);
    List<Long> cursosIdsDeEstudiante(Long estudianteId);

    // borrador logico metodo
    void eliminarLogico(Long id);
}
