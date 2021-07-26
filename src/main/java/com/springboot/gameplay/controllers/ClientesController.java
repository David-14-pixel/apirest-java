package com.springboot.gameplay.controllers;

import com.springboot.gameplay.models.entity.Cliente;
import com.springboot.gameplay.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
public class ClientesController {
    @Autowired
    private IClienteService iClienteService;
@GetMapping("/listar")
    public List<Cliente> findAllClientes(){
 return  iClienteService.findAllClientes();
}
@PostMapping("/guardar")
    public void saveCliente(@RequestBody Cliente cliente){
    iClienteService.saveCliente(cliente);
}

@PutMapping("/editar/{id}")
public void updateCliente(@PathVariable Long id,@RequestBody Cliente cliente){
    Cliente cliente1 = iClienteService.findById(id);
    cliente1.setNombre(cliente.getNombre());
    cliente1.setApellidos(cliente.getApellidos());
    cliente1.setDireccion(cliente.getDireccion());
    cliente1.setTelefono(cliente.getTelefono());
    iClienteService.saveCliente(cliente);

}
@PutMapping("/actualizarestado/{id}")
    public boolean updateEstado(@PathVariable Long id){
    return iClienteService.updateEstado(id);
}
}
