package com.example.pruebaconcesionaria.services.interfaces;
import com.example.pruebaconcesionaria.models.Cliente;

import java.util.List;

public interface IClienteService {

    void saveCliente(Cliente cliente);

    List<Cliente> getClientes();

    Cliente getClienteById(Long idCliente);

    Cliente editCliente(Cliente cliente);

    String deleteCliente(Long idCliente);
}
