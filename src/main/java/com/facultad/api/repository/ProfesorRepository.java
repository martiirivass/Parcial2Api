package com.facultad.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facultad.api.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> { }
