package com.energym.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResponseEntity<?> usuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			usuarios = usuarioService.findAll();
		} catch (Exception e) {
			response.put("mensaje", "No existen clientes");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
		
	}

}
