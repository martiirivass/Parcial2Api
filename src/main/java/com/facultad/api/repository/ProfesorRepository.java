package com.facultad.api.repository;

import com.facultad.api.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    // trae solo los profesores activos
    List<Profesor> findByActivoTrue();
}
