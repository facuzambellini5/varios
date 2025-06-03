package com.example.PruebaTecnicaJava.services.interfaces;

import com.example.PruebaTecnicaJava.dtos.CreateTransferenciaDTO;
import com.example.PruebaTecnicaJava.dtos.UpdateTransferenciaDTO;
import com.example.PruebaTecnicaJava.models.Transferencia;

import java.util.List;

public interface ITransferenciaService {

    String saveTransferencia(CreateTransferenciaDTO createTransferenciaDTO);

    List<Transferencia> getTransferencias();

    Transferencia getTransferenciaById(Long idTransferencia);

    Transferencia editTransferencia(Long idTransferencia, UpdateTransferenciaDTO UpdateTransferenciaDTO);

    String deleteTransferencia(Long idTransferencia);
}
