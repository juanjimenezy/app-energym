package com.energym.app.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pagos")
public class Pago {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPagoSequence")
	@SequenceGenerator(name = "idPagoSequence", sequenceName = "idPago_Sequence", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuario;
	
	
	private Concepto concepto;
	
	private Calendar fechaPago;
	
	private Calendar fechaPagoFin;
	
	private Double montoPago;

	private Double descuento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public Calendar getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Calendar getFechaPagoFin() {
		return fechaPagoFin;
	}

	public void setFechaPagoFin(Calendar fechaPagoFin) {
		this.fechaPagoFin = fechaPagoFin;
	}

	public Double getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
}
