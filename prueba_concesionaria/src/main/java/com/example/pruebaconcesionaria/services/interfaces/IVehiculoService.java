package com.example.pruebaconcesionaria.services.interfaces;
import com.example.pruebaconcesionaria.models.Vehiculo;
import java.util.List;

public interface IVehiculoService {

    String saveVehiculo(Vehiculo vehiculo);

    List<Vehiculo> getVehiculos();

    Vehiculo getVehiculoById(Long idVehiculo);

    Vehiculo editVehiculo(Vehiculo vehiculo);

    String deleteVehiculo(Long idVehiculo);

}