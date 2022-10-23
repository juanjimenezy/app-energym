package com.energym.app.services;

import java.util.List;

import com.energym.app.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario findByCedula(Long cedula);
	
	public Usuario findByNombre(String nombre);

}
