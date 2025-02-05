package com.proteccion.prueba.repository;

import com.proteccion.prueba.entities.FibonacciEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FibonacciRepository extends JpaRepository<FibonacciEntity, Long> {
}
