package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
