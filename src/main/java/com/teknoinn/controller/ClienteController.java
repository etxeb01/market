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
import com.teknoinn.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> listaClientes = clienteService.listar();
		
		return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody Cliente cliente) {
		Cliente obj = clienteService.registrar(cliente);
		//especialidades/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Cliente> update(@Validated @RequestBody Cliente cliente) {
		Cliente obj = clienteService.modificar(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Cliente obj = clienteService.leerPorId(id);
		if (obj.getIdCliente() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Cliente obj = clienteService.leerPorId(id);
		if (obj.getIdCliente() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		clienteService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
			

}
