package com.bncmy.clientes.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name="clientes")
public class Clientes implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)	
	@Column(name="id")
	private Long id;
	
	@Column(name="fecha_crea")
	private String fecha_crea;
	
	@Column(name="fecha_mod")
	private String fecha_mod;
	
	@Column(name="datospersonales_id")
	private Long datospersonales_id;
	
	@Column(name="estatus")
	private boolean estatus;


	public Long getCliente_id() {
		return id;
	}

	public void setCliente_id(Long cliente_id) {
		this.id = cliente_id;
	}

	public String getFecha_crea() {
		return fecha_crea;
	}

	public void setFecha_crea(String fecha_crea) {
		this.fecha_crea = fecha_crea;
	}

	public String getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(String fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public Long getDatospersonales_id() {
		return datospersonales_id;
	}

	public void setDatospersonales_id(Long datospersonales_id) {
		this.datospersonales_id = datospersonales_id;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
}
