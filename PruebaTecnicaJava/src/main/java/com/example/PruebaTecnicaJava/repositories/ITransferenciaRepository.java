package com.example.PruebaTecnicaJava.repositories;

import com.example.PruebaTecnicaJava.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferenciaRepository extends JpaRepository<Long, Transferencia> {}
