package com.empresa.springrest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.springrest.entity.Restaurante;
@Repository("restauranteRepository")
public interface RestauranteRepository  extends JpaRepository<Restaurante, Serializable>{
	public abstract Restaurante findByRestaurante( String Restaurante );
	public abstract List<Restaurante> findByDireccion( String Direccion );
	public abstract Restaurante findByIdRestauranteAndRestaurante(long id, String restaurante);
	public abstract Restaurante findByIdRestaurante(long idRestaurante);
}
