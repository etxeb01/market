package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Venta;
import com.teknoinn.repo.IVentaRepo;
import com.teknoinn.service.IVentaService;

@Service
public class IVentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo repo;
	
	@Override
	public Venta registrar(Venta obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Venta modificar(Venta obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Venta leerPorId(Integer id) {
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
