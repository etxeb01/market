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
import com.teknoinn.model.Marca;
import com.teknoinn.service.IMarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private IMarcaService marcaService;
	
	@GetMapping
	public ResponseEntity<List<Marca>> findAll(){
		List<Marca> listaMarcas = marcaService.listar();
		
		return new ResponseEntity<List<Marca>>(listaMarcas, HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody Marca marca) {
		Marca obj = marcaService.registrar(marca);
		//especialidades/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getIdMarca()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Marca> update(@Validated @RequestBody Marca marca) {
		Marca obj = marcaService.modificar(marca);
		return new ResponseEntity<Marca>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Marca> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Marca obj = marcaService.leerPorId(id);
		if (obj.getIdMarca() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Marca>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Marca obj = marcaService.leerPorId(id);
		if (obj.getIdMarca() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		marcaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
