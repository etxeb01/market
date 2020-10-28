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
import com.teknoinn.model.Producto;
import com.teknoinn.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;

	
	@GetMapping
	public ResponseEntity<List<Producto>> findAll(){
		List<Producto> listaProductos = productoService.listar();
		
		return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody Producto producto) {
		Producto obj = productoService.registrar(producto);
		//especialidades/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(producto.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Producto> update(@Validated @RequestBody Producto producto) {
		Producto obj = productoService.modificar(producto);
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Producto> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Producto obj = productoService.leerPorId(id);
		if (obj.getIdProducto() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Producto obj = productoService.leerPorId(id);
		if (obj.getIdProducto() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		productoService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
