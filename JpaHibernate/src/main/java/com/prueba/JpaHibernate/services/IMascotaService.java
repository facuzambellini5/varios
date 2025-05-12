package com.prueba.JpaHibernate.services;

import com.prueba.JpaHibernate.models.Mascota;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascotas();

    public void saveMascota(Mascota mascota);

    public void deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public void editMascota(Long idOriginal,
                            Long idNueva,
                            String nombreNuevo,
                            String especieNueva,
                            String razaNueva,
                            String colorNuevo);
}
