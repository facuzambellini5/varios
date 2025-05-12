package com.prueba.JpaHibernate.services;

import com.prueba.JpaHibernate.models.Mascota;
import com.prueba.JpaHibernate.repositories.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepo;

    @Override
    public List<Mascota> getMascotas() {
        return mascotaRepo.findAll();
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepo.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        return mascotaRepo.findById(id).orElse(null);
    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, String nombreNuevo, String especieNueva, String razaNueva, String colorNuevo) {

        Mascota mascota = this.findMascota(idOriginal);

        mascota.setId_mascota(idNueva);
        mascota.setNombre(nombreNuevo);
        mascota.setEspecie(especieNueva);
        mascota.setRaza(razaNueva);
        mascota.setColor(colorNuevo);

        this.saveMascota(mascota);
    }
}
