package com.todocode.finalIntegrador.service;

import com.todocode.finalIntegrador.models.Producto;
import com.todocode.finalIntegrador.models.Venta;
import com.todocode.finalIntegrador.models.dto.VentaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public Venta crearVenta(Venta venta);
    public List<Venta> getVentas();
    public Venta getVentaById(Long id);
    public void deleteById(Long id);
    public void editVenta(Venta venta);
    public List<Producto> listaDeProd(Long id);
    public String ventasFecha(LocalDate fecha);
    public VentaDTO mayorVenta();
    public List<Producto> getListaDeProductos(Long codigo_venta);
}
