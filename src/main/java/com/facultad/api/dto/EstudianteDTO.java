package com.facultad.api.dto;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String matricula;
}
