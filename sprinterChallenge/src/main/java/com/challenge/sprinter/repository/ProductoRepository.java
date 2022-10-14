package com.challenge.sprinter.repository;

import com.challenge.sprinter.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}