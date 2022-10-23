package com.energym.app.services;

import java.util.List;

import com.energym.app.models.Concepto;

public interface IConceptoService {
	
	public List<Concepto> findAll();
	
	public Concepto finById(Long id);

}
