package com.energym.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conceptos")
public class Concepto {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre_concepto")
	private String nombreConcepto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreConcepto() {
		return nombreConcepto;
	}

	public void setNombreConcepto(String nombreConcepto) {
		this.nombreConcepto = nombreConcepto;
	}
	
}
