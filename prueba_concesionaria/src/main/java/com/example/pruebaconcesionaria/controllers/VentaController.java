package com.example.pruebaconcesionaria.controllers;

import com.example.pruebaconcesionaria.dtos.VentaDTO;
import com.example.pruebaconcesionaria.models.Venta;
import com.example.pruebaconcesionaria.services.interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

  @Autowired IVentaService ventaService;

  @PostMapping("/guardar")
  public String saveVenta(@RequestBody VentaDTO ventaDTO) {
    return ventaService.saveVenta(ventaDTO);
  }

  @GetMapping("/traer")
  public List<Venta> getVentas() {
    return ventaService.getVentas();
  }

  @GetMapping("/traer/{idVenta}")
  public Venta getVentaById(@PathVariable Long idVenta) {
    return ventaService.getVentaById(idVenta);
  }

  @PostMapping("/editar")
  public Venta editVenta(@RequestBody VentaDTO ventaDTO) {
    return ventaService.editVenta(ventaDTO);
  }

  @DeleteMapping("/borrar/{idVenta}")
  public String deleteVenta(@PathVariable Long idVenta) {
    return ventaService.deleteVenta(idVenta);
  }
}
