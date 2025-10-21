package com.facultad.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String matricula;

    @JsonBackReference
    @ManyToMany(mappedBy = "estudiantes")
    private List<Curso> cursos;
}
