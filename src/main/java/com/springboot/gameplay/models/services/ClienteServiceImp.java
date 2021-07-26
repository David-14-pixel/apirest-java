package com.springboot.gameplay.models.services;

import com.springboot.gameplay.models.entity.Cliente;
import com.springboot.gameplay.models.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClienteServiceImp implements  IClienteService{
    @Autowired
    private IClienteRepository iClienteRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAllClientes() {
        return iClienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return iClienteRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void saveCliente(Cliente cliente) {
    iClienteRepository.save(cliente);
    }
    @Transactional
    @Override
    public boolean updateEstado(Long id) {
        Cliente cliente = iClienteRepository.findById(id).orElse(null);
        if(cliente==null){
            return false;
        }else
            if(cliente.isEstado()){
            iClienteRepository.updateEstado(false, cliente.getId());
        }else{
            iClienteRepository.updateEstado(true, cliente.getId());
        }
return true;
    }
}
