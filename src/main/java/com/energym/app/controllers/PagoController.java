package com.energym.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energym.app.models.Pago;
import com.energym.app.services.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	
	@GetMapping("/pagos")
	public ResponseEntity<?> findAll(){
		List<Pago> pagos = new ArrayList<Pago>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			pagos = pagoService.findAll();
			
			if(pagos.isEmpty()) {
				response.put("mensaje", "no hay pagos");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			response.put("mensaje", "error en consulta");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Pago>>(pagos,HttpStatus.OK);
	}
	
	@PostMapping("/pago") 
	public ResponseEntity<?> create(@RequestBody Pago pago){
		Pago newPago = new Pago();
		Map<String, Object> response = new HashMap<>();
		
		try {
			newPago = pagoService.save(pago);
		} catch (Exception e) {
			response.put("mensaje", "error al guardar");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Pago>(newPago,HttpStatus.OK);
	}

}
