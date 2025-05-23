package com.ejerciciopractico.cursosprogramacion.repositories;

import com.ejerciciopractico.cursosprogramacion.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
