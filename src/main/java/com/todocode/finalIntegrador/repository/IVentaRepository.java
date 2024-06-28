package com.todocode.finalIntegrador.repository;

import com.todocode.finalIntegrador.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
