package com.energym.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energym.app.models.Concepto;
import com.energym.app.repositories.ConceptoRepository;

@Service
public class ConceptoService implements IConceptoService{
	
	@Autowired
	private ConceptoRepository conceptoRepository;

	@Override
	public List<Concepto> findAll() {
		return (List<Concepto>) conceptoRepository.findAll();
	}

	@Override
	public Concepto finById(Long id) {
		return conceptoRepository.findById(id).orElse(null);
	}

}
