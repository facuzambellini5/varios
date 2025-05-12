package com.example.pruebaconcesionaria.services;

import com.example.pruebaconcesionaria.models.Empleado;
import com.example.pruebaconcesionaria.repositories.IEmpleadoRepository;

import com.example.pruebaconcesionaria.services.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

  @Autowired IEmpleadoRepository empleadoRepo;

  @Override
  public String saveEmpleado(Empleado empleado) {
    empleadoRepo.save(empleado);
    return "Empleado registrado correctamente.";
  }

  @Override
  public List<Empleado> getEmpleados() {
    return empleadoRepo.findAll();
  }

  @Override
  public Empleado getEmpleadoById(Long idEmpleado) {
    return empleadoRepo.findById(idEmpleado).orElse(null);
  }

  @Override
  public Empleado editEmpleado(Empleado empleado) {
    this.saveEmpleado(empleado);
    return this.getEmpleadoById(empleado.getIdEmpleado());
  }

  @Override
  public String deleteEmpleado(Long idEmpleado) {
    if (this.getEmpleadoById(idEmpleado) != null) {
      empleadoRepo.deleteById(idEmpleado);
      return "Empleado eliminado correctamente.";

    } else {
      return "No se ha encontrado el empleado.";
    }
  }
}
