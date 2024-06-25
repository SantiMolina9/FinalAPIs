package com.todocode.finalIntegrador.service.impl;

import com.todocode.finalIntegrador.models.Cliente;
import com.todocode.finalIntegrador.repository.IClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
    @Mock
    IClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;


    @Test
    void crearClienteTest(){
        Cliente cliente = new Cliente();
        clienteService.crearCliente(cliente);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void getClientesTest(){
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        //Devuelve un array como una lista mediante el metodo estatico asList()
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));
        List<Cliente> clientes = clienteService.getClientes();
        assertEquals(2, clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void getClienteById(){
        Cliente cliente = new Cliente();
        //Usa un optional porque puede ser nulo
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
        Cliente resultado = clienteService.getClienteById(1L);
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void deleteByIdTest(){
        clienteService.deleteById(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    void editByIdTest(){
        Cliente cliente = new Cliente();
        clienteService.editCliente(cliente);
        verify(clienteRepository, times(1)).save(cliente);
    }

}