package com.todocode.finalIntegrador.service.impl;

import com.todocode.finalIntegrador.models.Producto;
import com.todocode.finalIntegrador.repository.IProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {
    @Mock
    IProductoRepository productoRepository;

    @InjectMocks
    ProductoService productoService;

    @Test
    void crearProductoTest(){
        Producto producto = new Producto();
        productoService.crearProducto(producto);
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void getProductosTest(){
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1,producto2));
        List<Producto> productos = productoService.getProductos();
        assertEquals(2, productos.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void getProductoByIdTest() {
        Producto producto = new Producto();
        when(productoRepository.findById(anyLong())).thenReturn(Optional.of(producto));
        Producto llamado = productoService.getProductoById(1L);
        verify(productoRepository, times(1)).findById(1L);
    }

    @Test
    void deleteByIdTest(){
        productoService.deleteById(1L);
        verify(productoRepository, times(1)).deleteById(1L);
    }

    @Test
    void editProductoById(){
        Producto producto = new Producto();
        productoService.editProduct(producto);
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void stockMenorA5Test(){
        //Instancio algunos productos de prueba
        Producto producto = new Producto(1L,"Producto1",
                "Marca1", 25.2, 4.0);
        Producto producto2 = new Producto(2L,"Producto2",
                "Marca2", 20.0, 12.0);
        Producto producto3 = new Producto(3L, "Producto3",
                "Marca3", 20.2, 4.0);
        //Declaro una lista e inserto los productos en ella
        List<Producto> listaMenorA5 = new ArrayList<>();
        listaMenorA5.add(producto);
        listaMenorA5.add(producto2);
        listaMenorA5.add(producto3);
        //Cuando se llame al metodo va a retornar esta listaMenorA5
        when(productoService.stockMenorA5()).thenReturn(listaMenorA5);
        List<Producto> lista = productoService.stockMenorA5();

        assertEquals(producto, lista.get(0));
        assertEquals(producto3, lista.get(1));
        assertEquals(2, lista.size());
    }

}