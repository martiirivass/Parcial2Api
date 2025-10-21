package com.facultad.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facultad.api.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> { }
