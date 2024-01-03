package com.todocode.finalIntegrador.service.impl;

import com.todocode.finalIntegrador.models.Cliente;
import com.todocode.finalIntegrador.repository.IClienteRepository;
import com.todocode.finalIntegrador.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public void crearCliente(Cliente cliente) {

    }

    @Override
    public List<Cliente> getClientes() {
        return null;
    }

    @Override
    public Cliente getClienteById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void editCliente(Cliente cliente) {

    }
}
