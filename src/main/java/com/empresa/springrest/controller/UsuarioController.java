package com.empresa.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.springrest.entity.Restaurante;
import com.empresa.springrest.entity.Usuario;
import com.empresa.springrest.model.RestauranteModel;
import com.empresa.springrest.service.RestauranteService;
import com.empresa.springrest.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuario")
@Api(value = "User", description = "Rest API for user operations", tags = "User API")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "true"),
        @ApiResponse(code = 404, message = "The resource not found")
})

public class UsuarioController {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@PutMapping("/nuevo")
	@ApiOperation(value = "Create a new User", response = Usuario.class)
	public boolean agregarRestaurante(@RequestBody @Validated Usuario usuario) {
		return usuarioService.crear(usuario);
	}

}
