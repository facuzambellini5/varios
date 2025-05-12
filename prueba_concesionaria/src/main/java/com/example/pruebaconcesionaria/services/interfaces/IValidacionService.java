package com.example.pruebaconcesionaria.services.interfaces;

import com.example.pruebaconcesionaria.models.Cliente;
import com.example.pruebaconcesionaria.models.Empleado;
import com.example.pruebaconcesionaria.models.Vehiculo;

public interface IValidacionService {

    Cliente validarCliente(Long idCliente);
    Vehiculo validarVehiculo(Long idVehiculo);
    Empleado validarEmpleado(Long idEmpleado);
}
