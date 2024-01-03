package com.todocode.finalIntegrador.service;

import com.todocode.finalIntegrador.models.Venta;

import java.util.List;

public interface IVentaService {
    public void crearVenta(Venta venta);
    public List<Venta> getVentas();
    public Venta getVentaById(Long id);
    public void deleteById(Long id);
    public void editVenta(Venta venta);
}
