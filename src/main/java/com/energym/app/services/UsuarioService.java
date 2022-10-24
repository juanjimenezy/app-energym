package com.energym.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energym.app.models.Usuario;
import com.energym.app.repositories.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario findByCedula(Long cedula) {
		return usuarioRepository.findByCedula(cedula);
	}

	@Override
	public Usuario findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
