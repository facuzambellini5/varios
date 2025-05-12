package com.example.pruebaconcesionaria.services.interfaces;


import com.example.pruebaconcesionaria.dtos.ReservaDTO;
import com.example.pruebaconcesionaria.models.Reserva;

import java.util.List;

public interface IReservaService {

    String saveReserva(ReservaDTO reservaDTO);

    List<Reserva> getReservas();

    Reserva getReservaById(Long idReserva);

    Reserva editReserva(ReservaDTO reservaDTO);

    String deleteReserva(Long idReserva);

}
