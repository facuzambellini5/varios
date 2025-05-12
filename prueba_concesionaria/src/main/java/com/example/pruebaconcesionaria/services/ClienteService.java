package com.example.pruebaconcesionaria.services;

import com.example.pruebaconcesionaria.models.Cliente;
import com.example.pruebaconcesionaria.repositories.IClienteRepository;
import com.example.pruebaconcesionaria.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    IClienteRepository clienteRepo;

    @Override
    public void saveCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente getClienteById(Long idCliente) {
        return clienteRepo.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente editCliente(Cliente cliente){
        clienteRepo.save(cliente);
        return this.getClienteById(cliente.getIdCliente());
    }

    @Override
    public String deleteCliente(Long idCliente){
        if(this.getClienteById(idCliente) != null){
            clienteRepo.deleteById(idCliente);
            return "Cliente eliminado correctamente.";
        }else {
            return "El cliente no se ha encontrado.";
        }
    }

}
