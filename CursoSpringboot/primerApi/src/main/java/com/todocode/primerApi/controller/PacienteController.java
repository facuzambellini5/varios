package com.todocode.primerApi.controller;

import com.todocode.primerApi.models.PacienteModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


@RestController
public class PacienteController {

    @GetMapping("/traer")
    public ArrayList<PacienteModel> listaPacientes(){
        ArrayList<PacienteModel> lista = new ArrayList<>();
        lista.add(new PacienteModel(1,44222191,"Facu","González", LocalDate.of(2002,7,10)));
        lista.add(new PacienteModel(2,12345678,"Pepe","Argento", LocalDate.of(1995,3,6)));
        lista.add(new PacienteModel(3,87654321,"Juan","Cito", LocalDate.of(2010,6,25)));
        lista.add(new PacienteModel(4,55123698,"Pedro","Sanchez", LocalDate.of(1990,2,17)));
        lista.add(new PacienteModel(5,22448851,"Raulita","Perez", LocalDate.of(2000,9,2)));
        return lista;
    }
    @GetMapping("/menor")
    public ArrayList<PacienteModel> menorDeEdad(){
        ArrayList<PacienteModel> listaMenores = new ArrayList<>();

        for(PacienteModel paciente : listaPacientes()){
            if(Period.between(paciente.getFechaNac(),LocalDate.now()).getYears() < 18 ){
                listaMenores.add(paciente);

            }
        }
        return listaMenores;
    }

}
