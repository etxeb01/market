package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {

}
