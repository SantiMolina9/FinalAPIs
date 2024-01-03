package com.todocode.finalIntegrador.controllers;

import com.todocode.finalIntegrador.models.Producto;
import com.todocode.finalIntegrador.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoService.crearProducto(producto);
        return "Producto creado correctamente";
    }

    @GetMapping("productos")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @GetMapping("productos/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.getProductoById(id);
    }

    @DeleteMapping("productos/eliminar/{id}")
    public String deleteProductoById(@PathVariable Long id){
        productoService.deleteById(id);
        return "Producto eliminado correctamente";
    }

    @PutMapping("productos/editar/{id}")
    public Producto editProducto(@RequestBody Producto producto) {
        productoService.editProduct(producto);
        return productoService.getProductoById(producto.getCodigo_producto());
    }

    @GetMapping("productos/falta-stock")
    public List<Producto> getProductosStockMenorA5(){
        return productoService.stockMenorA5();
    }
}
