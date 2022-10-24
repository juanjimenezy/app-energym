package com.energym.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energym.app.models.Usuario;
import com.energym.app.services.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> usuario(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		Usuario usuario = null;
		
		try {
			usuario = usuarioService.findById(id);
			if(usuario == null) {
				response.put("mensaje", "usuario no existe");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", "error en consulta");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<?> usuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Map<String, Object> response = new HashMap<>();
		try {
			usuarios = usuarioService.findAll();
			if (usuarios.isEmpty()) {
				response.put("mensaje", "No existen clientes");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", "error en consulta");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		Usuario newUsuario = new Usuario();
		Map<String, Object> response = new HashMap<>();
		Usuario existUsuario = usuarioService.findByCedula(usuario.getCedula());
		
		if(!(existUsuario == null)) {
			response.put("mensaje", "Usuario ya existe");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			newUsuario = usuarioService.save(usuario);
		} catch (Exception e) {
			response.put("mensaje", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(newUsuario,HttpStatus.OK);
	}

}
