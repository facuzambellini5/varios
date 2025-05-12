package com.example.pruebaconcesionaria.dtos;

import com.example.pruebaconcesionaria.enums.MetodoPago;
import jakarta.persistence.*;

import java.time.LocalDate;

/** Esta clase se utiliza en {@link com.example.pruebaconcesionaria.services.VentaService} para:
 * <un>
 *  <li>Crear ventas.
 *  <li>Editar ventas.
 * </un>
 */
public class VentaDTO {

  private Long idVenta;
  private LocalDate fechaVenta;
  private Double total;

  @Enumerated(EnumType.STRING)
  private MetodoPago metodoPago;

  private Long idCliente;
  private Long idVehiculo;
  private Long idEmpleado;

  public VentaDTO() {}

  public VentaDTO(
      Long idVenta,
      LocalDate fechaVenta,
      Double total,
      MetodoPago metodoPago,
      Long idCliente,
      Long idVehiculo,
      Long idEmpleado) {
    this.idVenta = idVenta;
    this.fechaVenta = fechaVenta;
    this.total = total;
    this.metodoPago = metodoPago;
    this.idCliente = idCliente;
    this.idVehiculo = idVehiculo;
    this.idEmpleado = idEmpleado;
  }

  public Long getIdVenta() {
    return idVenta;
  }

  public void setIdVenta(Long idVenta) {
    this.idVenta = idVenta;
  }

  public LocalDate getFechaVenta() {
    return fechaVenta;
  }

  public void setFechaVenta(LocalDate fechaVenta) {
    this.fechaVenta = fechaVenta;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public MetodoPago getMetodoPago() {
    return metodoPago;
  }

  public void setMetodoPago(MetodoPago metodoPago) {
    this.metodoPago = metodoPago;
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public Long getIdVehiculo() {
    return idVehiculo;
  }

  public void setIdVehiculo(Long idVehiculo) {
    this.idVehiculo = idVehiculo;
  }

  public Long getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Long idEmpleado) {
    this.idEmpleado = idEmpleado;
  }
}
