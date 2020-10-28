package com.teknoinn.service;

import java.util.List;

import com.teknoinn.model.CompraProducto;

public interface ICompraProductoService {
	
	List<CompraProducto> listarComprasProductos(Integer idCompra);

}
