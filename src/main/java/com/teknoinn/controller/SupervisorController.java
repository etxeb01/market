package com.teknoinn.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teknoinn.exception.ModelNotFoundException;
import com.teknoinn.model.Supervisor;
import com.teknoinn.service.ISupervisorService;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {
	
	@Autowired
	private ISupervisorService supervisorService;
	
	
	@GetMapping
	public ResponseEntity<List<Supervisor>> findAll(){
		List<Supervisor> listaSupervisores = supervisorService.listar();
		
		return new ResponseEntity<List<Supervisor>>(listaSupervisores, HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody Supervisor supervisor) {
		Supervisor obj = supervisorService.registrar(supervisor);
		//especialidades/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(supervisor.getIdSupervisor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Supervisor> update(@Validated @RequestBody Supervisor supervisor) {
		Supervisor obj = supervisorService.modificar(supervisor);
		return new ResponseEntity<Supervisor>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Supervisor> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Supervisor obj = supervisorService.leerPorId(id);
		if (obj.getIdSupervisor() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Supervisor>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Supervisor obj = supervisorService.leerPorId(id);
		if (obj.getIdSupervisor() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		supervisorService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
