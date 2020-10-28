package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Producto;
import com.teknoinn.repo.IProductoRepo;
import com.teknoinn.service.IProductoService;

@Service
public class IProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo repo;
	
	@Override
	public Producto registrar(Producto obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Producto modificar(Producto obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Producto leerPorId(Integer id) {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
