package com.todocode.finalIntegrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
}
