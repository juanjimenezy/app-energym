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

	
}
