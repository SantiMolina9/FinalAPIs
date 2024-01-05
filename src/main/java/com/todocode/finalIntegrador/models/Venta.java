package com.todocode.finalIntegrador.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;

    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany
    @JoinTable(name = "venta_lista_productos",
    joinColumns = {@JoinColumn(name = "codigo_venta")},
    inverseJoinColumns = {@JoinColumn(name = "codigo_producto")}
    )
    private List<Producto> lista_productos;

    @ManyToOne
    private Cliente cliente;
}
