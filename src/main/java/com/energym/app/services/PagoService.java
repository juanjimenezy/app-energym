package com.energym.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energym.app.models.Pago;
import com.energym.app.repositories.PagoRepository;

@Service
public class PagoService implements IPagoService{
	
	@Autowired
	private PagoRepository pagoRepository;

	@Override
	public List<Pago> findAll() {
		return (List<Pago>) pagoRepository.findAll();
	}

	@Override
	public Pago findById(Long id) {
		return pagoRepository.findById(id).orElse(null);
	}

	@Override
	public Pago save(Pago pago) {
		return pagoRepository.save(pago);
	}
	
}
