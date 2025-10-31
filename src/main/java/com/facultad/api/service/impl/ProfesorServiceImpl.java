package com.facultad.api.service.impl;
import com.facultad.api.dto.ProfesorDTO;
import com.facultad.api.entity.Profesor;
import com.facultad.api.mapper.AppMapper;
import com.facultad.api.repository.ProfesorRepository;
import com.facultad.api.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service @RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository repo;

    @Override
    public List<ProfesorDTO> listar() {
        return repo.findAll().stream().map(AppMapper::toDTO).collect(toList());
    }

    @Override
    public ProfesorDTO crear(ProfesorDTO dto) {
        Profesor p = Profesor.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .build();
        p = repo.save(p);
        return AppMapper.toDTO(p);
    }
}
