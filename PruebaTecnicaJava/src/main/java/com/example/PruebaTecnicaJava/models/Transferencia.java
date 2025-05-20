package com.example.PruebaTecnicaJava.models;

import jakarta.persistence.*;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransferencia;

    private Double importe;
    private String cuentaDebito;
    private String cuentaCredito;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Transferencia() {
    }

    public Transferencia(Long idTransferencia, Double importe, String cuentaDebito, String cuentaCredito, Empresa empresa) {
        this.idTransferencia = idTransferencia;
        this.importe = importe;
        this.cuentaDebito = cuentaDebito;
        this.cuentaCredito = cuentaCredito;
        this.empresa = empresa;
    }

    public Long getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Long idTransferencia) {
        this.idTransferencia = idTransferencia;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
