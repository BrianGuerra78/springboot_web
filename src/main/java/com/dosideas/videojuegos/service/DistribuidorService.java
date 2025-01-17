package com.dosideas.videojuegos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dosideas.videojuegos.domain.Distribuidor;
import com.dosideas.videojuegos.repository.DistribuidorRepository;

@Service
public class DistribuidorService {

	private final DistribuidorRepository distribuidorRepository;

	public DistribuidorService(DistribuidorRepository distribuidorRepository) {
		this.distribuidorRepository = distribuidorRepository;
	}
	
	public List<Distribuidor> buscarTodos(){
		return distribuidorRepository.findAll();
	}
}
