package com.todocode.finalIntegrador.service;

import com.todocode.finalIntegrador.models.Producto;

import java.util.List;

public interface IProductoService {
    public void crearProducto(Producto producto);
    public List<Producto> getProductos();
    public Producto getProductoById(Long id);
    public void deleteById(Long id);
    public void editProduct(Producto producto);
    public List<Producto> stockMenorA5();
}
