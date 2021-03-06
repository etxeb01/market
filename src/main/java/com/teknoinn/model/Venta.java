package com.teknoinn.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVenta;
	
	// private Integer idVendedor;
		
	@ManyToOne
	@JoinColumn(name="id_vendedor",nullable=false, foreignKey = @ForeignKey(name="FK_venta_vendedor"))
	private Vendedor vendedor;
	
	// private Integer idCliente;
	@ManyToOne
	@JoinColumn(name="id_cliente",nullable=false, foreignKey = @ForeignKey(name="FK_venta_cliente"))
	private Cliente cliente;
	
	@Column(name="costo", length = 50, nullable=false)
	private int costo;
	
	
	private LocalDateTime fechaVenta;


	public Integer getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
	

}
