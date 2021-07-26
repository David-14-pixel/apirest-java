package com.springboot.gameplay.models.services;

import com.springboot.gameplay.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
public List<Cliente> findAllClientes();
Cliente findById(Long id);
public void saveCliente(Cliente cliente);
public boolean updateEstado(Long id);
}
