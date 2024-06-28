package com.todocode.finalIntegrador.service.impl;

import com.todocode.finalIntegrador.models.Producto;
import com.todocode.finalIntegrador.models.Venta;
import com.todocode.finalIntegrador.models.dto.VentaDTO;
import com.todocode.finalIntegrador.repository.IVentaRepository;
import com.todocode.finalIntegrador.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService {
    @Autowired
    IVentaRepository ventaRepository;

    @Override
    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("La venta con ID: " + id + " no existe."));
    }

    @Override
    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta) {
        this.crearVenta(venta);
    }


    @Override
    public String getVentasFecha(LocalDate fecha) {
        List<Venta> listaVentas = ventaRepository.findAll();

        List<Venta> listaFecha = listaVentas.stream()
                .filter(venta -> venta.getFecha_venta().equals(fecha))
                .collect(Collectors.toList());

        int cantidad = listaFecha.size();
        Double montoTotal = 0D;

        for(Venta venta: listaFecha){
             montoTotal += venta.getTotal();
        }

        return "La cantidad de ventas realizadas en la fecha: " + fecha + ", fueron: "
            + cantidad + ". El monto total de estas ventas fue de: $" + montoTotal;
    }

    @Override
    public VentaDTO mayorVenta() {
        //Obtengo todas las ventas realizadas hasta el momento
        List<Venta> listaVentas = ventaRepository.findAll();
        //1. Declaro una nueva venta
        //2. Tomo la lista de ventas, la trato como stream y tomo el maximo,
        // comparando los totales de todas las ventas. Utiliza la interface Comparator.
        Venta ventaMayor = listaVentas.stream()
                .max(Comparator.comparingDouble(Venta::getTotal)).orElse(null);

        //Seteo cada uno de los atributos del DTO con los datos de la ventaMayor.
        Long codigo_venta = ventaMayor.getCodigo_venta();
        Double total = ventaMayor.getTotal();
        int cantidad_productos = ventaMayor.getLista_productos().size();
        String nombre = ventaMayor.getCliente().getNombre();
        String apellido = ventaMayor.getCliente().getApellido();

        //Instancio un objeto DTO y lo retorno.
        VentaDTO mayorVenta = new VentaDTO(codigo_venta,total,
                cantidad_productos,nombre,apellido);

        return mayorVenta;
    }

    @Override
    public List<Producto> getListaDeProductos(Long codigo_venta) {
        Venta venta = ventaRepository.findById(codigo_venta).orElse(null);
        List<Producto> listaDeProductos = venta.getLista_productos();
        return listaDeProductos;
    }

}
