package com.atsistemas.concesionario.mongo.aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.mongo.entidades.Vehiculo;
import com.atsistemas.concesionario.mongo.persistencia.VehiculoRepository;

@RestController
@RequestMapping(path="/vehiculo")
public class VehiculoRestController {
	
	@Autowired
	private VehiculoRepository repositorio;
	   
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity insertar (@RequestBody Vehiculo vehiculo){		
		repositorio.insert(vehiculo);		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Vehiculo>> listar (){						
	public ResponseEntity listar (){						
		return new ResponseEntity<List<Vehiculo>>(repositorio.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Vehiculo> getUsuarioPorId (@PathVariable Long id){
		return new ResponseEntity<Vehiculo>(repositorio.findById(id),HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity borrarPorId (@PathVariable Long id){
		repositorio.delete(repositorio.findById(id));
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity actualizar (@RequestBody Vehiculo vehiculo){
		repositorio.save(vehiculo);
		return new ResponseEntity(HttpStatus.OK);
	}


}
