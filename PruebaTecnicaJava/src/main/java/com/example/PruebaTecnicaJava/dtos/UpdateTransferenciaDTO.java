package com.example.PruebaTecnicaJava.dtos;

import jakarta.validation.constraints.NotBlank;

public class UpdateTransferenciaDTO {

    @NotBlank(message = "Debe ingresar un importe.")
    private Double importe;

    @NotBlank(message = "Debe ingresar una cuenta de débito.")
    private String cuentaDebito;

    @NotBlank(message = "Debe ingresar una cuenta de crédito.")
    private String cuentaCredito;

    @NotBlank(message = "Debe ingresar un ID de la empresa correspondiente.")
    private Long idEmpresa;

    public UpdateTransferenciaDTO() {
    }

    public UpdateTransferenciaDTO(Double importe, String cuentaDebito, String cuentaCredito, Long idEmpresa) {
        this.importe = importe;
        this.cuentaDebito = cuentaDebito;
        this.cuentaCredito = cuentaCredito;
        this.idEmpresa = idEmpresa;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getCuentaDebito() {
        return cuentaDebito;
    }

    public void setCuentaDebito(String cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public String getCuentaCredito() {
        return cuentaCredito;
    }

    public void setCuentaCredito(String cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
