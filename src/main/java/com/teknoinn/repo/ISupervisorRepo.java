package com.teknoinn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teknoinn.model.Supervisor;

public interface ISupervisorRepo extends JpaRepository<Supervisor, Integer> {

}
