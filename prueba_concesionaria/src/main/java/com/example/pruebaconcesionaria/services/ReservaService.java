package com.example.pruebaconcesionaria.services;

import com.example.pruebaconcesionaria.dtos.ReservaDTO;
import com.example.pruebaconcesionaria.enums.EstadoVehiculo;
import com.example.pruebaconcesionaria.models.Cliente;
import com.example.pruebaconcesionaria.models.Reserva;
import com.example.pruebaconcesionaria.models.Vehiculo;
import com.example.pruebaconcesionaria.repositories.IClienteRepository;
import com.example.pruebaconcesionaria.repositories.IReservaRepository;
import com.example.pruebaconcesionaria.repositories.IVehiculoRepository;
import com.example.pruebaconcesionaria.services.interfaces.IReservaService;
import com.example.pruebaconcesionaria.services.interfaces.IValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    IReservaRepository reservaRepo;

    @Autowired
    IVehiculoRepository vehiculoRepo;

    @Autowired
    IClienteRepository clienteRepo;

    @Autowired
    IValidacionService validacionService;

    /**
     * Este metodo recibe un {@link ReservaDTO} en donde el idReservaDTO debe ser NULL ya que al crear
     * una reserva, Hibernate se encargará de generar la Id.
     * Llama a los metodos de validación para Cliente y Vehiculo dentro de {@link ValidacionService}
     * Luego se realizan los respectivos seteos para cliente, vehiculo y reserva para luego guardar los cambios,
     * asi como la nueva reserva creada.
     *
     * @param reservaDTO
     * @return
     */
    
    @Override
    public String saveReserva(ReservaDTO reservaDTO) {

        Cliente cliente = validacionService.validarCliente(reservaDTO.getIdCliente());
        Vehiculo vehiculo = validacionService.validarVehiculo(reservaDTO.getIdVehiculo());

        Reserva reserva = new Reserva();
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setSena(reservaDTO.getSena());
        reserva.setCliente(cliente);
        reserva.setVehiculo(vehiculo);

        cliente.getReservas().add(reserva);
        vehiculo.setEstado(EstadoVehiculo.RESERVADO);

        clienteRepo.save(cliente);
        vehiculoRepo.save(vehiculo);
        reservaRepo.save(reserva);
        return "Reserva realizada correctamente a nombre de: " + cliente.getNombre() + "\nVehículo: " +
                vehiculo.getMarca() + ", " + vehiculo.getModelo() + "\nMonto abonado: " + reserva.getSena();
    }

    
    @Override
    public List<Reserva> getReservas() {
        return reservaRepo.findAll();
    }

    
    @Override
    public Reserva getReservaById(Long idReserva) {
        return reservaRepo.findById(idReserva).orElse(null);
    }


    /**
     * El metodo recibe una ReservaDTO CON idReserva,
     * Valida si el id es null, y si la reserva a editar se encuentra en la BD.
     * Llama a los metodos de validación para Cliente y Vehiculo dentro de {@link ValidacionService}
     *
     * @throws RuntimeException en caso de que el idReserva sea null o no se encuentre la id en cuestion
     * en la BD. Además también puede lanzar una excepción del lado de {@link ValidacionService} en caso de que
     * no pase la validación.
     *
     * @param reservaDTO CON idReserva, de lo contrario lanzará una excepción.
     * @return devuelve la reserva actualizada: {@link Reserva}
     */
    @Override
    public Reserva editReserva(ReservaDTO reservaDTO) {

        if(reservaDTO.getIdReservaDTO() == null){
            throw new RuntimeException("ID necesaria para editar una reserva.");
        }

        Reserva reserva = this.getReservaById(reservaDTO.getIdReservaDTO());
        if(reserva == null){throw new RuntimeException("Reserva no encontrada.");}

        Vehiculo nuevoVehiculo = validacionService.validarVehiculo(reservaDTO.getIdVehiculo());
        Cliente nuevoCliente = validacionService.validarCliente(reservaDTO.getIdCliente());

        Cliente clienteAnterior = reserva.getCliente();

        if(!clienteAnterior.getIdCliente().equals(nuevoCliente.getIdCliente())){
            clienteAnterior.getReservas().remove(reserva);
            nuevoCliente.getReservas().add(reserva);
        }

        Vehiculo vehiculoAnterior = reserva.getVehiculo();

        if(!vehiculoAnterior.getIdVehiculo().equals(nuevoVehiculo.getIdVehiculo())){
            vehiculoAnterior.setEstado(EstadoVehiculo.DISPONIBLE);
            nuevoVehiculo.setEstado(EstadoVehiculo.RESERVADO);
        }

        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setSena(reserva.getSena());
        reserva.setCliente(nuevoCliente);
        reserva.setVehiculo(nuevoVehiculo);

        reservaRepo.save(reserva);
        clienteRepo.save(clienteAnterior);
        clienteRepo.save(nuevoCliente);
        vehiculoRepo.save(vehiculoAnterior);
        vehiculoRepo.save(nuevoVehiculo);

        return reserva;
    }

    
    @Override
    public String deleteReserva(Long idReserva) {
        if(this.getReservaById(idReserva) != null){
            reservaRepo.deleteById(idReserva);
            return "Reserva eliminada correctamente.";
        }else {
            return "No se ha encontrado la reserva.";
        }
    }
}
