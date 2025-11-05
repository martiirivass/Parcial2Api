package com.facultad.api.service;

import com.facultad.api.dto.*;
import java.util.List;

public interface CursoService {
    List<CursoDTO> listar();
    CursoDTO crear(CreateCursoRequest req);
    CursoDTO asignarEstudiante(Long cursoId, Long estudianteId);
    List<CursoDTO> cursosDeEstudiante(Long estudianteId);

    // metodo borrador logico
    void eliminarLogico(Long id);
}
