package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Vendedor;
import com.teknoinn.repo.IVendedorRepo;
import com.teknoinn.service.IVendedorService;

@Service
public class IVendedorServiceImpl implements IVendedorService {
	
	@Autowired
	private IVendedorRepo repo;

	@Override
	public Vendedor registrar(Vendedor obj) {
		return repo.save(obj);
	}

	@Override
	public Vendedor modificar(Vendedor obj) {
		return repo.save(obj);
	}

	@Override
	public List<Vendedor> listar() {
		return repo.findAll();
	}

	@Override
	public Vendedor leerPorId(Integer id) {
		Optional<Vendedor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Vendedor();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
