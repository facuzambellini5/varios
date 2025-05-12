package com.example.pruebaconcesionaria.services.interfaces;

import com.example.pruebaconcesionaria.models.Empleado;

import java.util.List;

public interface IEmpleadoService {

    String saveEmpleado(Empleado empleado);

    List<Empleado> getEmpleados();

    Empleado getEmpleadoById(Long idEmpleado);

    Empleado editEmpleado(Empleado empleado);

    String deleteEmpleado(Long idEmpleado);
}
