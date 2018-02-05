package com.empresa.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.empresa.springrest.converter.ConvertidorRestaurante;
import com.empresa.springrest.entity.Restaurante;
import com.empresa.springrest.model.RestauranteModel;
import com.empresa.springrest.repository.RestauranteRepository;

@Service("RestauranteService")
public class RestauranteService {
	@Autowired
	@Qualifier("restauranteRepository")
	private RestauranteRepository repositorio;
	@Autowired
	@Qualifier("convertidorRestaurante")
	private ConvertidorRestaurante convRestaurante;
	
	public boolean crear(Restaurante restaurante) {
		try {
			repositorio.save(restaurante);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean actualizar(Restaurante restaurante) {
		try {
			repositorio.save(restaurante);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean borrar(long id) {
		try {
			Restaurante restaurante= repositorio.findByIdRestaurante(id);
			repositorio.delete(restaurante);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<RestauranteModel> obtener() {
		List<Restaurante> restaurante = repositorio.findAll();
		List<RestauranteModel> restauranteModel= convRestaurante.convertirLista(restaurante);
		return restauranteModel;
	}
	public RestauranteModel obtenerRestaurante(long id) {
		Restaurante restaurante = repositorio.findByIdRestaurante(id);	
		return new RestauranteModel(restaurante);
	}
	
}
