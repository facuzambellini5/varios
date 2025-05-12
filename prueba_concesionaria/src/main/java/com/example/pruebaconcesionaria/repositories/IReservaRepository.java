package com.example.pruebaconcesionaria.repositories;

import com.example.pruebaconcesionaria.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {
}
