package com.facultad.api.dto;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CursoDTO {
    private Long id;
    private String nombre;
    private Long profesorId;
    private String profesorNombre;
    private List<Long> estudiantesIds;
}
