package com.facultad.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facultad.api.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> { }
