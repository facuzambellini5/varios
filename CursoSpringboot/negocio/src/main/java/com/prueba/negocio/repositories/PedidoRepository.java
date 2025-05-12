package com.prueba.negocio.repositories;

import com.prueba.negocio.models.ClienteModel;
import com.prueba.negocio.models.PedidoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoModel, Long> {
    public abstract ArrayList<PedidoModel> findByCliente(ClienteModel cliente);
}
