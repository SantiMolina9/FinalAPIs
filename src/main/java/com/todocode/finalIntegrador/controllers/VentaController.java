package com.todocode.finalIntegrador.controllers;

import com.todocode.finalIntegrador.models.Producto;
import com.todocode.finalIntegrador.models.Venta;
import com.todocode.finalIntegrador.models.dto.VentaDTO;
import com.todocode.finalIntegrador.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {
    @Autowired
    IVentaService ventaService;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaService.crearVenta(venta);
        return "Venta creada correctamente";
    }

    @GetMapping("ventas")
    public List<Venta> getVentas(){
        var venta = ventaService.getVentas();
        return venta;
    }

    @GetMapping("ventas/{id}")
    public Venta getVentaById(@PathVariable Long id){
        return ventaService.getVentaById(id);
    }

    @DeleteMapping("ventas/eliminar/{id}")
    public String deleteVentaById(@PathVariable Long id){
        ventaService.deleteById(id);
        return "Venta eliminada correctamente";
    }

    @PutMapping("ventas/editar/{id}")
    public Venta editVenta(@RequestBody Venta venta) {
        ventaService.editVenta(venta);
        return ventaService.getVentaById(venta.getCodigo_venta());
    }
    @GetMapping("ventas/productos/{codigo_venta}")
    public List<Producto> getListaProductos(@PathVariable Long codigo_venta){
        return ventaService.getListaDeProductos(codigo_venta);
    }

    @GetMapping("ventas/fecha/{fecha}")
    public String getVentasPorFecha(@PathVariable LocalDate fecha){
        return ventaService.getVentasFecha(fecha);
    }

    @GetMapping("ventas/mayor_venta")
    public VentaDTO mayorVenta(){
        return ventaService.mayorVenta();
    }

}
