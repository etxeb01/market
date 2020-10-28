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
import com.teknoinn.model.Venta;
import com.teknoinn.service.IVentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;
	
	@GetMapping
	public ResponseEntity<List<Venta>> findAll(){
		List<Venta> listaVentas = ventaService.listar();
		
		return new ResponseEntity<List<Venta>>(listaVentas, HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody Venta venta) {
		Venta obj = ventaService.registrar(venta);
		//especialidades/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Venta> update(@Validated @RequestBody Venta venta) {
		Venta obj = ventaService.modificar(venta);
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Venta> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Venta obj = ventaService.leerPorId(id);
		if (obj.getIdVenta() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Venta obj = ventaService.leerPorId(id);
		if (obj.getIdVenta() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		ventaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	

}
