package com.example.PruebaTecnicaJava.services;

import com.example.PruebaTecnicaJava.models.Transferencia;

import java.util.List;

public interface ITransferenciaService {

    String saveTransferencia(Transferencia transferencia);

    List<Transferencia> getTransferencias();

    Transferencia getTransferenciaById(Long idTransferencia);

    Transferencia editTransferencia(Transferencia transferencia);

    String deleteTransferencia(Long idTransferencia);
}
