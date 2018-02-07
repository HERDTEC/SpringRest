package com.empresa.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.springrest.entity.Restaurante;
import com.empresa.springrest.model.RestauranteModel;
import com.empresa.springrest.service.RestauranteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1")
@Api(value = "Restaurante", description = "Rest API for resturant operations", tags = "Restaurante API")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "true"),
        @ApiResponse(code = 404, message = "The resource not found")
})

public class RestauranteController {
	@Autowired
	@Qualifier("RestauranteService")
	private RestauranteService restauranteServicio;
	@PutMapping("/restaurante")
	@ApiOperation(value = "Create a new Restaurant", response = RestauranteModel.class)
	public boolean agregarRestaurante(@RequestBody @Validated Restaurante restaurante) {
		return restauranteServicio.crear(restaurante);
	}
}
