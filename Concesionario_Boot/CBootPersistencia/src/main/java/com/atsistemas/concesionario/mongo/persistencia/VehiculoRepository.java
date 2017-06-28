package com.atsistemas.concesionario.mongo.persistencia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.atsistemas.concesionario.mongo.entidades.Vehiculo;

public interface VehiculoRepository extends MongoRepository<Vehiculo,Long>{
	
	Vehiculo findById(Long id);

	List<Vehiculo> findByModelo(String modelo);

}
