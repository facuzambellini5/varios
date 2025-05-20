package com.example.PruebaTecnicaJava.repositories;

import com.example.PruebaTecnicaJava.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {
}
