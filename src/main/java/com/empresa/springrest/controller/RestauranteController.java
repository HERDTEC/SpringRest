package com.empresa.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.springrest.entity.Restaurante;
import com.empresa.springrest.service.RestauranteService;

@RestController
@RequestMapping("/v1")
public class RestauranteController {
	@Autowired
	@Qualifier("RestauranteService")
	private RestauranteService restauranteServicio;
	@PutMapping("/restaurante")
	public boolean agregarRestaurante(@RequestBody @Validated Restaurante restaurante) {
		return restauranteServicio.crear(restaurante);
	}
}
