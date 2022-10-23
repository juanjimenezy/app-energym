package com.energym.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energym.app.models.Usuario;
import com.energym.app.services.IUsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> usuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			usuarios = usuarioService.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
		
	}

}
