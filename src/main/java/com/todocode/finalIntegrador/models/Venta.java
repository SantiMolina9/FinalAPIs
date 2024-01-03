package com.todocode.finalIntegrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    private List<Producto> lista_productos;
    private Cliente unCliente;
}
