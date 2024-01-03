package com.todocode.finalIntegrador.service;

import com.todocode.finalIntegrador.models.Cliente;
import com.todocode.finalIntegrador.models.Producto;

import java.util.List;

public interface IClienteService {
    public void crearCliente(Cliente cliente);
    public List<Cliente> getClientes();
    public Cliente getClienteById(Long id);
    public void deleteById(Long id);
    public void editCliente(Cliente cliente);
}
