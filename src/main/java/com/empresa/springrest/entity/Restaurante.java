package com.empresa.springrest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurantes")
@Entity
public class Restaurante implements Serializable {
	@GeneratedValue
	@Id
	@Column(name="idrestaurante")
	private long idRestaurante;
	@Column(name="idcategoria")
	private long idCategoria;
	@Column(name="restaurante")
	private String restaurante;
	@Column(name="direccion")
	private String direccion;

	
	public Restaurante() {
		
	}
	public Restaurante(long id, long idCategoria, String restaurante, String direccion, String distrito) {
		super();
		this.idRestaurante = idRestaurante;
		this.idCategoria = idCategoria;
		this.restaurante = restaurante;
		this.direccion = direccion;
		
	}
	public long getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
