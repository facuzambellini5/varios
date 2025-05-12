package com.example.pruebaconcesionaria.controllers;

import com.example.pruebaconcesionaria.models.Empleado;
import com.example.pruebaconcesionaria.services.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

  @Autowired IEmpleadoService empleadoService;

  @PostMapping("/guardar")
  public String saveEmpleado(@RequestBody Empleado empleado) {
    return empleadoService.saveEmpleado(empleado);
  }

  @GetMapping("/traer")
  public List<Empleado> getEmpleados() {
    return empleadoService.getEmpleados();
  }

  @GetMapping("/traer/{idEmpleado}")
  public Empleado getEmpleadoById(@PathVariable Long idEmpleado) {
    return empleadoService.getEmpleadoById(idEmpleado);
  }

  @PutMapping("/editar")
  public Empleado editEmpleado(Empleado empleado) {
    return empleadoService.editEmpleado(empleado);
  }

  @DeleteMapping("/borrar/{idEmpleado}")
  public String deleteEmpleado(@PathVariable Long idEmpleado) {
    return empleadoService.deleteEmpleado(idEmpleado);
  }
}
