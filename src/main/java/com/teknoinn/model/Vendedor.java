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
@Table(name="vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVendedor;
	
	// private Integer idSupervisor;
	@ManyToOne
	@JoinColumn(name="id_supervisor",nullable=false,foreignKey=@ForeignKey(name="FK_vendedor_supervisor"))
	private Supervisor supervisor;
	
	@Column(name="nombre_vendedor", length = 50, nullable=false)
	private String nombreVendedor;
	
	@Column(name="direccion_vendedor", length = 50, nullable=false)
	private String dirVendedor;

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getDirVendedor() {
		return dirVendedor;
	}

	public void setDirVendedor(String dirVendedor) {
		this.dirVendedor = dirVendedor;
	}

	
	
}
