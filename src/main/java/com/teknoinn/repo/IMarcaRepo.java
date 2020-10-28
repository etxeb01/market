package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Marca;

public interface IMarcaRepo extends JpaRepository<Marca, Integer> {

}
