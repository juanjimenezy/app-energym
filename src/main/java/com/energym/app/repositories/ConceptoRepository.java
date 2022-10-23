package com.energym.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.energym.app.models.Concepto;

@Repository
public interface ConceptoRepository extends CrudRepository<Concepto, Long>{

}
