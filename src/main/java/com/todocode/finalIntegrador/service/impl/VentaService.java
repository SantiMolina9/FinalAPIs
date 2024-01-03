package com.todocode.finalIntegrador.service.impl;

import com.todocode.finalIntegrador.models.Venta;
import com.todocode.finalIntegrador.repository.IVentaRepository;
import com.todocode.finalIntegrador.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    IVentaRepository ventaRepository;

    @Override
    public void crearVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta) {
        this.crearVenta(venta);
    }
    
}
