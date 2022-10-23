package com.energym.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.energym.app.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.cedula = :cedula")
	Usuario findByCedula(@Param("cedula")Long cedula);
	
	@Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
	Usuario findByNombre(@Param("nombre")String nombre);

}
