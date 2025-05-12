package com.example.pruebaconcesionaria.controllers;

import com.example.pruebaconcesionaria.models.Vehiculo;
import com.example.pruebaconcesionaria.services.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping("/guardar")
    public String saveVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoService.saveVehiculo(vehiculo);
    }

    @GetMapping("/traer")
    public List<Vehiculo> getVehiculos(){
        return vehiculoService.getVehiculos();
    }

    @GetMapping("/traer/{idVehiculo}")
    public Vehiculo getVehiculoById(@PathVariable Long idVehiculo) { return vehiculoService.getVehiculoById(idVehiculo); }

    @PutMapping("/editar")
    public Vehiculo editVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoService.editVehiculo(vehiculo);
    }

    @DeleteMapping("/borrar/{idVehiculo}")
    public String deleteVehiculo(@PathVariable Long idVehiculo) { return vehiculoService.deleteVehiculo(idVehiculo); }
}
