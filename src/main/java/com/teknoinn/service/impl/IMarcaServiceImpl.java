package com.teknoinn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknoinn.model.Marca;
import com.teknoinn.repo.IMarcaRepo;
import com.teknoinn.service.IMarcaService;

@Service
public class IMarcaServiceImpl implements IMarcaService {
	
	@Autowired
	private IMarcaRepo repo;
	
	@Override
	public Marca registrar(Marca obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Marca modificar(Marca obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Marca> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Marca leerPorId(Integer id) {
		Optional<Marca> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Marca();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
