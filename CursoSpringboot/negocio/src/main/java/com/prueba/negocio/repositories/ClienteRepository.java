package com.prueba.negocio.repositories;

import com.prueba.negocio.models.ClienteModel;
import com.prueba.negocio.models.PedidoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ClienteRepository extends CrudRepository<ClienteModel,Long> {

    public abstract ArrayList<ClienteModel> findByNombre(String nombre);
    public abstract ClienteModel findByPedidos(PedidoModel pedido);
}
