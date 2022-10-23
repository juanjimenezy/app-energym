package com.energym.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.energym.app.models.Pago;

@Repository
public interface PagoRepository extends CrudRepository<Pago,Long>{

}
