package com.example.pruebaconcesionaria.services.interfaces;

import com.example.pruebaconcesionaria.dtos.VentaDTO;
import com.example.pruebaconcesionaria.dtos.VentaResumenDTO;
import com.example.pruebaconcesionaria.models.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    String saveVenta(VentaDTO ventaDTO);

    List<Venta> getVentas();

    Venta getVentaById(Long idVenta);

    Venta editVenta(VentaDTO ventaDTO);

    String deleteVenta(Long idVenta);

    VentaResumenDTO findByFechaVenta(LocalDate fechaVenta);

    VentaResumenDTO findByFechaVentaBetween(LocalDate fechaInicio, LocalDate fechaFin);

}
