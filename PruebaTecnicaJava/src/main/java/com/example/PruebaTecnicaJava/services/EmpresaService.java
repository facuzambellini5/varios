package com.example.PruebaTecnicaJava.services;

import com.example.PruebaTecnicaJava.models.Empresa;
import com.example.PruebaTecnicaJava.repositories.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements IEmpresaService {

  @Autowired IEmpresaRepository empresaRepo;

  @Override
  public String saveEmpresa(Empresa empresa) {

    try {
      empresaRepo.save(empresa);
    } catch (RuntimeException e) {
      throw new RuntimeException("Se ha producido un error.", e);
    }

    return "Empresa guardada correctamente.";
  }

  @Override
  public List<Empresa> getEmpresas() {
    return empresaRepo.findAll();
  }

  @Override
  public Empresa getEmpresaById(Long idEmpresa) {
    return empresaRepo.findById(idEmpresa).orElse(null);
  }

  @Override
  public Empresa editEmpresa(Empresa empresa) {

    if (empresa.getIdEmpresa() == null) {
      throw new RuntimeException("Debe ingresar un ID para especificar la empresa a editar.");
    }

    Empresa empresa1 = this.getEmpresaById(empresa.getIdEmpresa());
    if (empresa1 == null) {
      throw new RuntimeException("No se ha encontrado la empresa a editar.");
    }

    this.saveEmpresa(empresa);
    return empresa;
  }

  @Override
  public String deleteEmpresa(Long idEmpresa) {
    return "";
  }
}
