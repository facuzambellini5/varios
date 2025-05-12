package com.example.pruebaconcesionaria.dtos;

import com.example.pruebaconcesionaria.models.Venta;
import java.util.List;

public class VentaResumenDTO {

  String mensaje;
  int cantidadventas;
  Double totalRecaudado;
  List<Venta> ventas;

  public VentaResumenDTO() {}

  public VentaResumenDTO(
      String mensaje, int cantidadventas, Double totalRecaudado, List<Venta> ventas) {
    this.mensaje = mensaje;
    this.cantidadventas = cantidadventas;
    this.totalRecaudado = totalRecaudado;
    this.ventas = ventas;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public void setCantidadventas(int cantidadventas) {
    this.cantidadventas = cantidadventas;
  }

  public void setTotalRecaudado(Double totalRecaudado) {
    this.totalRecaudado = totalRecaudado;
  }

  public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
  }
}
