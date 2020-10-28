package com.teknoinn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teknoinn.exception.ModelNotFoundException;
import com.teknoinn.model.CompraProducto;
import com.teknoinn.service.ICompraProductoService;

@RestController
@RequestMapping("/compraproducto")
public class CompraProductoController {
	
	@Autowired
	private ICompraProductoService productoService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<List<CompraProducto>> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		
		List<CompraProducto> lista = productoService.listarComprasProductos(id);
				 
		if (lista == null) {
			throw new ModelNotFoundException("LISTA NO ENCONTRADA" + id);
		}
		return new ResponseEntity<List<CompraProducto>>(lista, HttpStatus.OK);
	}
	
	
	
}
