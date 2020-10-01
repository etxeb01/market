package com.teknoinn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supervisor")
public class Supervisor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSupervisor;
	
	@Column(name="nombre_supervisor", length=50, nullable=false)
	private String nombreSupervisor;
	
	@Column(name="direccion_supervisor", length=50, nullable=false)
	private String dirSupervisor;
	
	@Column(name="telefono_supervisor", length=50, nullable=false)
	private String telSupervisor;

	public Integer getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Integer idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public String getDirSupervisor() {
		return dirSupervisor;
	}

	public void setDirSupervisor(String dirSupervisor) {
		this.dirSupervisor = dirSupervisor;
	}

	public String getTelSupervisor() {
		return telSupervisor;
	}

	public void setTelSupervisor(String telSupervisor) {
		this.telSupervisor = telSupervisor;
	}
	
	

}
