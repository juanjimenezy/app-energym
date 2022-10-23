package com.energym.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pagos")
public class Pago implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPagoSequence")
	@SequenceGenerator(name = "idPagoSequence", sequenceName = "idPago_Sequence", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="concepto_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Concepto concepto;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="fecha_pago")
	@Temporal(TemporalType.DATE)
	private Date fechaPago;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="fecha_pago_fin")
	@Temporal(TemporalType.DATE)
	private Date fechaPagoFin;
	
	@Column(name="monto_pago")
	private Double montoPago;

	@Column(name="descuento")
	private Double descuento;
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaPagoFin() {
		return fechaPagoFin;
	}

	public void setFechaPagoFin(Date fechaPagoFin) {
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
	
	private static final long serialVersionUID = 1L;
	
}
