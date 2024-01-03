package com.todocode.finalIntegrador.service.impl;

import com.todocode.finalIntegrador.models.Producto;
import com.todocode.finalIntegrador.repository.IProductoRepository;
import com.todocode.finalIntegrador.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;
    @Override
    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editProduct(Producto producto) {
        this.crearProducto(producto);
    }

    @Override
    public List<Producto> stockMenorA5() {
        List<Producto> listaProductos = productoRepository.findAll();
       List<Producto> listaMenorA5 = listaProductos.stream().filter(producto -> producto.getCantidad_disponible() < 5)
               .collect(Collectors.toList());
        return listaMenorA5;
    }

}
