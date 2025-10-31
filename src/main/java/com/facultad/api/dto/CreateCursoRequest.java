package com.facultad.api.dto;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateCursoRequest {
    private String nombre;
    private Long profesorId; // requisito: crear curso con su profesor
}
