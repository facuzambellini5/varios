package com.ejerciciopractico.cursosprogramacion.repositories;

import com.ejerciciopractico.cursosprogramacion.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository<Tema, Long> {
}
