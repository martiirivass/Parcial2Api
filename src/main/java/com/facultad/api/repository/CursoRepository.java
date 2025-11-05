package com.facultad.api.repository;

import com.facultad.api.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // trae solo los cursos activos
    List<Curso> findByActivoTrue();
}
