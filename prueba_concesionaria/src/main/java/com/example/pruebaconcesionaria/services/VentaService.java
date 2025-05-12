package com.example.pruebaconcesionaria.services;

import com.example.pruebaconcesionaria.dtos.VentaDTO;
import com.example.pruebaconcesionaria.dtos.VentaResumenDTO;
import com.example.pruebaconcesionaria.enums.EstadoVehiculo;
import com.example.pruebaconcesionaria.models.Cliente;
import com.example.pruebaconcesionaria.models.Empleado;
import com.example.pruebaconcesionaria.models.Vehiculo;
import com.example.pruebaconcesionaria.models.Venta;
import com.example.pruebaconcesionaria.repositories.IClienteRepository;
import com.example.pruebaconcesionaria.repositories.IEmpleadoRepository;
import com.example.pruebaconcesionaria.repositories.IVehiculoRepository;
import com.example.pruebaconcesionaria.repositories.IVentaRepository;
import com.example.pruebaconcesionaria.services.interfaces.IValidacionService;
import com.example.pruebaconcesionaria.services.interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {

  @Autowired IVentaRepository ventaRepo;
  @Autowired IEmpleadoRepository empleadoRepo;
  @Autowired IClienteRepository clienteRepo;
  @Autowired IVehiculoRepository vehiculoRepo;
  @Autowired IValidacionService validacionService;

  /**
   * Registra una nueva venta.
   *
   * <p>Este metodo valida la existencia del cliente, vehículo y empleado con {@link
   * ValidacionService}a partir de los IDs proporcionados en el {@link VentaDTO} con . Luego crea
   * una nueva instancia de {@link Venta}, la asocia con las entidades correspondientes, actualiza
   * el estado del vehículo, y guarda todos los cambios en la base de datos.
   *
   * @param ventaDTO el DTO que contiene los datos necesarios para realizar la venta, incluyendo IDs
   *     de cliente, vehículo y empleado, fecha y metodo de pago.
   * @return un mensaje de confirmación con el nombre del cliente, datos del vehículo y el total de
   *     la venta.
   * @throws RuntimeException si alguno de los IDs proporcionados no corresponde a una entidad
   *     existente o si el vehículo no se encuentra DISPONIBLE.
   */
  @Override
  public String saveVenta(VentaDTO ventaDTO) {

    Cliente cliente = validacionService.validarCliente(ventaDTO.getIdCliente());
    Vehiculo vehiculo = validacionService.validarVehiculo(ventaDTO.getIdVehiculo());
    Empleado empleado = validacionService.validarEmpleado(ventaDTO.getIdEmpleado());

    Venta venta = new Venta();
    venta.setFechaVenta(ventaDTO.getFechaVenta());
    venta.setMetodoPago(ventaDTO.getMetodoPago());
    venta.setCliente(cliente);
    venta.setVehiculo(vehiculo);
    venta.setEmpleado(empleado);
    venta.setTotal(vehiculo.getPrecio());

    vehiculo.setEstado(EstadoVehiculo.VENDIDO);
    cliente.getCompras().add(venta);
    empleado.getVentas().add(venta);

    ventaRepo.save(venta);
    clienteRepo.save(cliente);
    vehiculoRepo.save(vehiculo);
    empleadoRepo.save(empleado);

    return "Venta realizada exitosamente a nombre de: "
        + cliente.getApellido()
        + ", "
        + cliente.getNombre()
        + ".\nVehículo: "
        + vehiculo.getMarca()
        + ", "
        + vehiculo.getModelo()
        + "\nTotal: "
        + venta.getTotal();
  }

  @Override
  public List<Venta> getVentas() {
    return ventaRepo.findAll();
  }

  @Override
  public Venta getVentaById(Long idVenta) {
    return ventaRepo.findById(idVenta).orElse(null);
  }

  /**
   * Edita una venta existente.
   *
   * <p>Este metodo hace:
   *
   * <ul>
   *   <li>Recibe los datos de {@link VentaDTO} y valida la existencia de la venta usando el idVenta
   *       recibido.
   *   <li>Valida con {@link ValidacionService} la existencia del cliente, empleado y vehículo, y si
   *       el vehículo esta DISPONIBLE.
   *   <li>En caso de producirse cambios, se actualizan del lado de cliente, empleado o vehículo.
   *   <li>Actualiza los estados del vehículo si se ha cambiado.
   *   <li>Reasigna la venta a un nuevo cliente o empleado si corresponde.
   *   <li>Guarda los cambios en la base de datos.
   * </ul>
   *
   * @param ventaDTO que contiene los datos a actualizar de la venta.
   * @return La venta actualizada.
   * @throws RuntimeException si el idVenta es null o si no se encuentra la venta.
   *     Además de poder producirse alguna excepción del lado de {@link ValidacionService} si no
   *     pasa alguna validación.
   */
  @Override
  public Venta editVenta(VentaDTO ventaDTO) {

    if (ventaDTO.getIdVenta() == null) {
      throw new RuntimeException("ID necesaria para editar una venta.");
    }
    Venta venta = this.getVentaById(ventaDTO.getIdVenta());
    if (venta == null) {
      throw new RuntimeException("Venta no encontrada.");
    }

    Cliente clienteNuevo = validacionService.validarCliente(ventaDTO.getIdCliente());
    Vehiculo vehiculoNuevo = validacionService.validarVehiculo(ventaDTO.getIdVehiculo());
    Empleado empleadoNuevo = validacionService.validarEmpleado(ventaDTO.getIdEmpleado());

    Cliente clienteAnterior = venta.getCliente();
    if (!clienteAnterior.getIdCliente().equals(clienteNuevo.getIdCliente())) {
      clienteAnterior.getCompras().remove(venta);
      clienteNuevo.getCompras().add(venta);
    }

    Vehiculo vehiculoAnterior = venta.getVehiculo();
    if (!vehiculoAnterior.getIdVehiculo().equals(vehiculoNuevo.getIdVehiculo())) {
      vehiculoAnterior.setEstado(EstadoVehiculo.DISPONIBLE);
      vehiculoNuevo.setEstado(EstadoVehiculo.VENDIDO);
    }

    Empleado empleadoAnterior = venta.getEmpleado();
    if (!empleadoAnterior.getIdEmpleado().equals(empleadoNuevo.getIdEmpleado())) {
      empleadoAnterior.getVentas().remove(venta);
      empleadoNuevo.getVentas().add(venta);
    }

    venta.setTotal(vehiculoNuevo.getPrecio());
    venta.setFechaVenta(ventaDTO.getFechaVenta());
    venta.setMetodoPago(ventaDTO.getMetodoPago());
    venta.setEmpleado(empleadoNuevo);
    venta.setCliente(clienteNuevo);
    venta.setVehiculo(vehiculoNuevo);

    empleadoRepo.save(empleadoAnterior);
    empleadoRepo.save(empleadoNuevo);
    clienteRepo.save(clienteAnterior);
    clienteRepo.save(clienteNuevo);
    vehiculoRepo.save(vehiculoAnterior);
    vehiculoRepo.save(vehiculoNuevo);
    ventaRepo.save(venta);

    return venta;
  }

  @Override
  public String deleteVenta(Long idVenta) {
    if (this.getVentaById(idVenta) != null) {
      ventaRepo.deleteById(idVenta);
      return "Venta eliminada corretamente.";
    } else {
      return "Venta no encontrada.";
    }
  }

  /**
   * Encontrar ventas de una fecha en específico.
   *
   * <p>Este metodo hace lo siguiente:
   * <un>
   *    <li>Recibe una fechaVenta que se la manda al metodo correspondiente en {@link IVentaRepository}
   *     que devuelve una List de todas las {@link Venta} de la fecha en cuestión.
   *    <li>Crea una instancia de {@link VentaResumenDTO}
   *    <li>Almacena todas las ventas en una List para poder recorrer las ventas y así obtener el
   *     total.
   *    <li>Setea los valores cantidadVentas, mensaje, totalRecaudado y las ventas a {@link VentaResumenDTO}
   * </un>
   *
   * @param fechaVenta
   * @return {@link VentaResumenDTO} listo para ser mostrado.
   */
  @Override
  public VentaResumenDTO findByFechaVenta(LocalDate fechaVenta) {

    VentaResumenDTO ventaResumenDTO = new VentaResumenDTO();
    List<Venta> listaVentas = ventaRepo.findByFechaVenta(fechaVenta);

    Double total = 0.0;
    for (Venta venta : listaVentas) {
      total += venta.getTotal();
    }

    ventaResumenDTO.setMensaje("Resumen de ventas de la fecha: " + fechaVenta);
    ventaResumenDTO.setCantidadventas(listaVentas.size());
    ventaResumenDTO.setTotalRecaudado(total);
    ventaResumenDTO.setVentas(listaVentas);

    return ventaResumenDTO;
  }

  /**
   * Encontrar ventas de un periodo de tiempo.
   *
   * <p>Este metodo hace lo siguiente:
   * <un>
   *    <li>Recibe una fechaInicio, y una fechaFin que se la manda al metodo correspondiente en {@link IVentaRepository}
   *     que devuelve una List de todas las {@link Venta} que se encuentre dentro de ese periodo de tiempo.
   *    <li>Crea una instancia de {@link VentaResumenDTO}
   *    <li>Almacena todas las ventas en una List para poder recorrer las ventas y así obtener el
   *     total.
   *    <li>Setea los valores cantidadVentas, mensaje, totalRecaudado y las ventas a {@link VentaResumenDTO}
   * </un>
   *
   * @param fechaInicio
   * @param fechaFin
   * @return {@link VentaResumenDTO} listo para ser mostrado.
   */

  @Override
  public VentaResumenDTO findByFechaVentaBetween(LocalDate fechaInicio, LocalDate fechaFin) {

    VentaResumenDTO ventaResumenDTO = new VentaResumenDTO();
    List<Venta> listaVentas = ventaRepo.findByFechaVentaBetween(fechaInicio, fechaFin);

    Double total = 0.0;
    for (Venta venta : listaVentas) {
      total += venta.getTotal();
    }

    ventaResumenDTO.setMensaje(
        "Resumen de ventas desde la fecha: " + fechaInicio + " hasta " + fechaFin);
    ventaResumenDTO.setCantidadventas(listaVentas.size());
    ventaResumenDTO.setTotalRecaudado(total);
    ventaResumenDTO.setVentas(listaVentas);

    return ventaResumenDTO;
  }
}
