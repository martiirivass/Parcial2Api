package com.facultad.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
}
