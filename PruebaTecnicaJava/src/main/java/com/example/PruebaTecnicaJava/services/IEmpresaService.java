package com.example.PruebaTecnicaJava.services;

import com.example.PruebaTecnicaJava.models.Empresa;

import java.util.List;

public interface IEmpresaService {

    String saveEmpresa(Empresa empresa);

    List<Empresa> getEmpresas();

    Empresa getEmpresaById(Long idEmpresa);

    Empresa editEmpresa(Empresa empresa);

    String deleteEmpresa(Long idEmpresa);

}
