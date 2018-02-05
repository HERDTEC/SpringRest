package com.empresa.springrest.model;

import com.empresa.springrest.entity.Restaurante;

public class RestauranteModel {
	private long idRestaurante;
	private long idCategoria;
	private String restaurante;
	private String direccion;
	public RestauranteModel(Restaurante restaurante) {
		this.idRestaurante = restaurante.getIdRestaurante();
		this.idCategoria = restaurante.getIdCategoria();
		this.restaurante = restaurante.getRestaurante();
		this.direccion = restaurante.getDireccion();
		
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
