package com.example.PruebaTecnicaJava.services.interfaces;

import com.example.PruebaTecnicaJava.models.Empresa;
import com.example.PruebaTecnicaJava.models.Transferencia;

public interface IValidacionService {

    Empresa validarEmpresa(Long idEmpresa);

    Transferencia validarTransferencia(Long idTransferencia);
}
