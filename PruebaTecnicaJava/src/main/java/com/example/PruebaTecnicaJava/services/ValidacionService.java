package com.example.PruebaTecnicaJava.services;

import com.example.PruebaTecnicaJava.models.Empresa;
import com.example.PruebaTecnicaJava.models.Transferencia;
import com.example.PruebaTecnicaJava.repositories.IEmpresaRepository;
import com.example.PruebaTecnicaJava.repositories.ITransferenciaRepository;
import com.example.PruebaTecnicaJava.services.interfaces.IValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionService implements IValidacionService {

    @Autowired
    IEmpresaRepository empresaRepo;

    @Autowired
    ITransferenciaRepository transferenciaRepo;

    @Override
    public Empresa validarEmpresa(Long idEmpresa) {

        Empresa empresa = empresaRepo.findById(idEmpresa).orElse(null);
        if(empresa == null){
            throw new RuntimeException("Empresa con ID: "+ idEmpresa +" no encontrada.");
        }
        return empresa;
    }

    @Override
    public Transferencia validarTransferencia(Long idTransferencia) {
        Transferencia transferencia = transferenciaRepo.findById(idTransferencia).orElse(null);

        if(transferencia == null){
            throw new RuntimeException("Transferencia con ID: "+ idTransferencia +" no encontrada.");
        }
        return transferencia;
    }
}
