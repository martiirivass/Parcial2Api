package com.facultad.api.repository;

import com.facultad.api.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    //trae solo los estudiantes activos
    List<Estudiante> findByActivoTrue();
}
