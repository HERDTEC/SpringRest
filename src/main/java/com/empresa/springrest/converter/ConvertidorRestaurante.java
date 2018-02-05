package com.empresa.springrest.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.empresa.springrest.entity.Restaurante;
import com.empresa.springrest.model.RestauranteModel;

@Component("convertidorRestaurante")
public class ConvertidorRestaurante {
	public List<RestauranteModel> convertirLista(List<Restaurante> restaurantes){
		List<RestauranteModel> restauranteM = new ArrayList<>();
		for(Restaurante rest : restaurantes) {
			restauranteM.add(new RestauranteModel(rest));
		}
		return restauranteM;
	}
}
