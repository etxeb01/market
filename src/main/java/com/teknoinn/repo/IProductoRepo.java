package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
