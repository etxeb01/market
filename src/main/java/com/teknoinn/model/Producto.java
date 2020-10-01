package com.teknoinn.model;

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
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Column(name="descripcion", length = 100, nullable=false)
	private String descripcion;
	
	// private Integer idMarca;
	@ManyToOne
	@JoinColumn(name="id_marca",nullable=false,foreignKey=@ForeignKey(name="FK_producto_marca"))
	private Marca marca;
	
	@Column(name="valor_producto", length = 20, nullable=false)
	private int valorProducto;
	
	

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public int getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(int valorProducto) {
		this.valorProducto = valorProducto;
	}

	
	
}
