package com.facultad.api.controller;
import com.facultad.api.dto.ProfesorDTO;
import com.facultad.api.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService service;

    @GetMapping
    public List<ProfesorDTO> listar() { return service.listar(); }

    @PostMapping
    public ResponseEntity<ProfesorDTO> crear(@RequestBody ProfesorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(dto));
    }
}
