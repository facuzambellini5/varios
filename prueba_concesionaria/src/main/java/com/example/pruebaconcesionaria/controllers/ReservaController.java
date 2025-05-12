package com.example.pruebaconcesionaria.controllers;

import com.example.pruebaconcesionaria.dtos.ReservaDTO;
import com.example.pruebaconcesionaria.models.Reserva;
import com.example.pruebaconcesionaria.services.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    IReservaService reservaService;

    @PostMapping("/guardar")
    public String saveReserva(@RequestBody ReservaDTO reservaDTO){
        return reservaService.saveReserva(reservaDTO);
    }

    @GetMapping("/traer")
    public List<Reserva> getReservas(){
        return reservaService.getReservas();
    }

    @GetMapping("/traer/{idReserva}")
    public Reserva getReservaById(@PathVariable Long idReserva){
        return reservaService.getReservaById(idReserva);
    }

    @PutMapping("/editar")
    public Reserva editReserva(@RequestBody ReservaDTO reservaDTO){
        return reservaService.editReserva(reservaDTO);
    }

    @DeleteMapping("/borrar/{idReserva}")
    public String deleteReserva(@PathVariable Long idReserva){
        return reservaService.deleteReserva(idReserva);
    }
}
