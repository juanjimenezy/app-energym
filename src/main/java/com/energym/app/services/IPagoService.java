package com.energym.app.services;

import java.util.List;

import com.energym.app.models.Pago;

public interface IPagoService {
	
	public List<Pago> findAll();
	
	public Pago findById(Long id);
	
	public Pago save(Pago pago);

}
