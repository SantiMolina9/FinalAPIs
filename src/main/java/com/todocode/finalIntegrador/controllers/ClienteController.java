package com.todocode.finalIntegrador.controllers;

import com.todocode.finalIntegrador.models.Cliente;
import com.todocode.finalIntegrador.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    IClienteService clienteService;

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteService.crearCliente(cliente);
        return "Cliente creado correctamente";
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("clientes/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }

    @DeleteMapping("clientes/eliminar/{id}")
    public String deleteClienteById(@PathVariable Long id){
        clienteService.deleteById(id);
        return "Cliente eliminado correctamente";
    }

    @PutMapping("clientes/editar")
    public Cliente editProducto(@RequestBody Cliente cliente) {
        clienteService.editCliente(cliente);
        return clienteService.getClienteById(cliente.getId_cliente());
    }

}
