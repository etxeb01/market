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
import com.teknoinn.model.Cliente;
import com.teknoinn.model.Vendedor;
import com.teknoinn.service.IVendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private IVendedorService vendedorService;
	
	@GetMapping
	public ResponseEntity<List<Vendedor>> findAll(){
		List<Vendedor> listaVendedores = vendedorService.listar();
		
		return new ResponseEntity<List<Vendedor>>(listaVendedores, HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody Vendedor vendedor) {
		Vendedor obj = vendedorService.registrar(vendedor);
		//especialidades/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedor.getIdVendedor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Vendedor> update(@Validated @RequestBody Vendedor vendedor) {
		Vendedor obj = vendedorService.modificar(vendedor);
		return new ResponseEntity<Vendedor>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Vendedor obj = vendedorService.leerPorId(id);
		if (obj.getIdVendedor() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Vendedor>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws ModelNotFoundException {
		
		Vendedor obj = vendedorService.leerPorId(id);
		if (obj.getIdVendedor() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		vendedorService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
