package com.facultad.api.service;
import com.facultad.api.dto.ProfesorDTO;
import java.util.List;

public interface ProfesorService {
    List<ProfesorDTO> listar();
    ProfesorDTO crear(ProfesorDTO dto);
}
