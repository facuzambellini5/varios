package com.example.pruebaconcesionaria.services;

import com.example.pruebaconcesionaria.enums.EstadoVehiculo;
import com.example.pruebaconcesionaria.models.Cliente;
import com.example.pruebaconcesionaria.models.Empleado;
import com.example.pruebaconcesionaria.models.Vehiculo;
import com.example.pruebaconcesionaria.repositories.IClienteRepository;
import com.example.pruebaconcesionaria.repositories.IEmpleadoRepository;
import com.example.pruebaconcesionaria.repositories.IVehiculoRepository;
import com.example.pruebaconcesionaria.services.interfaces.IValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionService implements IValidacionService {

    @Autowired
    IClienteRepository clienteRepo;
    @Autowired
    IVehiculoRepository vehiculoRepo;
    @Autowired
    IEmpleadoRepository empleadoRepo;

/**
 * Recibe una idCLiente para validar si se encuentra en la BD.
 * @throws RuntimeException en caso de que no se encuentre a el cliente.
*
 * @param idCliente
 * @return {@link Cliente}
*/
    @Override
    public Cliente validarCliente(Long idCliente) {
        Cliente cliente = clienteRepo.findById(idCliente).orElse(null);
        if (cliente == null){
            throw new RuntimeException("Cliente no encontrado.");
        }
        return cliente;
    }

/**
 * Recibe una idVehiculo para validar si se encuentra en la BD, y si se encuentra DISPONIBLE.
 * @throws RuntimeException en caso de que no se encuentre al vehículo, o si este NO esta DISPONIBLE.
*
 * @param idVehiculo
 * @return {@link Vehiculo}
*/
    @Override
    public Vehiculo validarVehiculo(Long idVehiculo) {
        Vehiculo vehiculo = vehiculoRepo.findById(idVehiculo).orElse(null);
        if (vehiculo == null){
            throw new RuntimeException("Vehiculo no encontrado");
        }
        if (!vehiculo.getEstado().equals(EstadoVehiculo.DISPONIBLE)){
            throw new RuntimeException("El vehículo no se encuentra disponible. Estado del vehículo: "
                    .concat(vehiculo.getEstado().toString()));
        }
        return vehiculo;
    }

/**
 * Recibe una idEmpleado para validar si se encuentra en la BD.
 * @throws RuntimeException en caso de que no se encuentre el empleado.
*
 * @param idEmpleado
 * @return {@link Empleado}
*/
    @Override
    public Empleado validarEmpleado(Long idEmpleado) {
        Empleado empleado = empleadoRepo.findById(idEmpleado).orElse(null);
        if (empleado == null){
            throw new RuntimeException("Empleado no encontrado");
        }
        return empleado;
    }
}
