package com.teknoinn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.CompraProducto;
import com.teknoinn.repo.ICompraProductoRepo;
import com.teknoinn.service.ICompraProductoService;

@Service
public class ICompraProductoServiceImpl implements ICompraProductoService {

	@Autowired
	private ICompraProductoRepo repo;
	
	@Override
	public List<CompraProducto> listarComprasProductos(Integer idCompra) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
