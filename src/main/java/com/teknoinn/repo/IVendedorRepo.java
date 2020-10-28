package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Vendedor;

public interface IVendedorRepo extends JpaRepository<Vendedor, Integer> {

}
