package com.example.pruebaconcesionaria.services;

import com.example.pruebaconcesionaria.models.Vehiculo;
import com.example.pruebaconcesionaria.repositories.IVehiculoRepository;
import com.example.pruebaconcesionaria.services.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {


    @Autowired
    IVehiculoRepository vehiculoRepo;

    @Override
    public String saveVehiculo(Vehiculo vehiculo) {
        vehiculoRepo.save(vehiculo);
        return "Vehiculo creado correctamente.";
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return vehiculoRepo.findAll();
    }

    @Override
    public Vehiculo getVehiculoById(Long idVehiculo){
        return vehiculoRepo.findById(idVehiculo).orElse(null);
    }

    @Override
    public Vehiculo editVehiculo(Vehiculo vehiculo) {
        vehiculoRepo.save(vehiculo);
        return this.getVehiculoById(vehiculo.getIdVehiculo());
    }

    @Override
    public String deleteVehiculo(Long idVehiculo) {
        if(this.getVehiculoById(idVehiculo) != null){
            vehiculoRepo.deleteById(idVehiculo);
            return "Vehiculo eliminado correctamente.";
        }else{
            return "No se ha encontrado el vehiculo.";
        }
    }
}
