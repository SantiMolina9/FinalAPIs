package com.todocode.finalIntegrador.models.dto;

import com.todocode.finalIntegrador.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;
    private String nombre_cliente;
    private String apellido_cliente;
}
