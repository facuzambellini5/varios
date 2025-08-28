package com.example.PruebaTecnicaJava.services;

import com.example.PruebaTecnicaJava.dtos.CreateTransferenciaDTO;
import com.example.PruebaTecnicaJava.dtos.UpdateTransferenciaDTO;
import com.example.PruebaTecnicaJava.models.Empresa;
import com.example.PruebaTecnicaJava.models.Transferencia;
import com.example.PruebaTecnicaJava.repositories.IEmpresaRepository;
import com.example.PruebaTecnicaJava.repositories.ITransferenciaRepository;
import com.example.PruebaTecnicaJava.services.interfaces.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferenciaService implements ITransferenciaService {

  @Autowired ITransferenciaRepository transferenciaRepo;

  @Autowired IEmpresaRepository empresaRepo;

  @Autowired ValidacionService validacionService;

  @Override
  public String saveTransferencia(CreateTransferenciaDTO createTransferenciaDTO) {

    Transferencia transferencia = new Transferencia();
    Empresa empresa = validacionService.validarEmpresa(createTransferenciaDTO.getIdEmpresa());

    transferencia.setCuentaCredito(createTransferenciaDTO.getCuentaCredito());
    transferencia.setCuentaDebito(createTransferenciaDTO.getCuentaDebito());
    transferencia.setImporte(createTransferenciaDTO.getImporte());
    transferencia.setEmpresa(empresa);
    empresa.getTransferencias().add(transferencia);

    try {
      transferenciaRepo.save(transferencia);
      empresaRepo.save(empresa);
    } catch (RuntimeException e) {
      throw new RuntimeException("Se ha producido un error.");
    }
    return "Transferencia registrada correctamente.";
  }

  @Override
  public List<Transferencia> getTransferencias() {
    return transferenciaRepo.findAll();
  }

  @Override
  public Transferencia getTransferenciaById(Long idTransferencia) {
    return transferenciaRepo.findById(idTransferencia).orElse(null);
  }

  @Override
  @Transactional
  public Transferencia editTransferencia (Long idTransferencia, UpdateTransferenciaDTO updateTransferenciaDTO) {

    Transferencia transferencia = validacionService.validarTransferencia(idTransferencia);

    transferencia.setCuentaCredito(updateTransferenciaDTO.getCuentaCredito());
    transferencia.setImporte(updateTransferenciaDTO.getImporte());
    transferencia.setCuentaDebito(updateTransferenciaDTO.getCuentaDebito());

    if(!transferencia.getEmpresa().getIdEmpresa().equals(updateTransferenciaDTO.getIdEmpresa())){

      Empresa empresaAnterior = transferencia.getEmpresa();
      Empresa empresaNueva = validacionService.validarEmpresa(updateTransferenciaDTO.getIdEmpresa());

      transferencia.setEmpresa(empresaNueva);
      empresaNueva.getTransferencias().add(transferencia);
      empresaAnterior.getTransferencias().remove(transferencia);
      empresaRepo.save(empresaAnterior);
      empresaRepo.save(empresaNueva);
    }

    transferenciaRepo.save(transferencia);
    return transferencia;
  }

  @Override
  public String deleteTransferencia(Long idTransferencia) {

    if (this.getTransferenciaById(idTransferencia) != null) {
      try {
        transferenciaRepo.deleteById(idTransferencia);
        return "Transferencia eliminada correctamente.";
      } catch (RuntimeException e) {
        throw new RuntimeException("Se ha producido un error.", e);
      }
    } else {
      return "No se ha encontrado la transferencia con ID " + idTransferencia;
    }
  }
}
