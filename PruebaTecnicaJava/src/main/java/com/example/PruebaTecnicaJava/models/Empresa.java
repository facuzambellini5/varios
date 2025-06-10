package com.example.PruebaTecnicaJava.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Empresa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEmpresa;

  private Long cuit;
  private String razonSocial;
  private LocalDate fechaAdhesion;
  private Boolean esActiva;
  private LocalDate fechaBaja;

  @OneToMany(mappedBy = "empresa")
  private List<Transferencia> transferencias;

  public Empresa() {}

  public Empresa(
      Long idEmpresa,
      Long cuit,
      String razonSocial,
      LocalDate fechaAdhesion,
      Boolean esActiva,
      LocalDate fechaBaja,
      List<Transferencia> transferencias) {
    this.idEmpresa = idEmpresa;
    this.cuit = cuit;
    this.razonSocial = razonSocial;
    this.fechaAdhesion = fechaAdhesion;
    this.esActiva = esActiva;
    this.fechaBaja = fechaBaja;
    this.transferencias = transferencias;
  }

    public Boolean getEsActiva() {
        return esActiva;
    }

    public void setEsActiva(Boolean esActiva) {
        this.esActiva = esActiva;
    }

    public LocalDate getFechaBaja() {
    return fechaBaja;
  }

  public void setFechaBaja(LocalDate fechaBaja) {
    this.fechaBaja = fechaBaja;
  }

  public Long getIdEmpresa() {
    return idEmpresa;
  }

  public void setIdEmpresa(Long idEmpresa) {
    this.idEmpresa = idEmpresa;
  }

  public Long getCuit() {
    return cuit;
  }

  public void setCuit(Long cuit) {
    this.cuit = cuit;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public LocalDate getFechaAdhesion() {
    return fechaAdhesion;
  }

  public void setFechaAdhesion(LocalDate fechaAdhesion) {
    this.fechaAdhesion = fechaAdhesion;
  }

  public List<Transferencia> getTransferencias() {
    return transferencias;
  }

  public void setTransferencias(List<Transferencia> transferencias) {
    this.transferencias = transferencias;
  }
}
