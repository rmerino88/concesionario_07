package com.atsistemas.concesionario.mongo.aplicacion;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.atsistemas.concesionario.mongo.entidades.Vehiculo;
import com.atsistemas.concesionario.mongo.persistencia.VehiculoRepository;

@SpringBootApplication/*(scanBasePackages = { "com.atsistemas.concesionario.mongo.aplicacion", "com.atsistemas.concesionario.mongo.entidades", "com.atsistemas.concesionario.mongo.rest.controllers", "com.atsistemas.concesionario.mongo.persistencia"})*/
@EnableMongoRepositories("com.atsistemas.concesionario.mongo.persistencia")
/*
 * A pesar de hacer el ComponentScan y pasar el CBootController a war 
 * no reconoce la clase de los controladores que está en otro paquete
 * @ComponentScan({ "com.atsistemas.concesionario.mongo.rest.controllers" })
 */
public class MongoAplication implements CommandLineRunner {

	@Autowired
	private VehiculoRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		this.repository.deleteAll();
		// fetch all customers
		System.out.println("Vehiculos found with findAll() after deleteAll():");
		System.out.println("-------------------------------");
		for (Vehiculo vehiculo : this.repository.findAll()) {
			System.out.println(vehiculo.toString());
		}
		System.out.println();
		// save a couple of customers
		this.repository.save(new Vehiculo(1L,"DESCRIPCION1","MODELO1","COLOR1","MOTOR1",new BigDecimal(9999)));
		this.repository.save(new Vehiculo(2L,"DESCRIPCION2","MODELO1","COLOR2","MOTOR2",new BigDecimal(8888)));
		this.repository.save(new Vehiculo(3L,"DESCRIPCION3","MODELO1","COLOR3","MOTOR3",new BigDecimal(7777)));
		this.repository.save(new Vehiculo(4L,"DESCRIPCION4","MODELO2","COLOR4","MOTOR4",new BigDecimal(6666)));
		this.repository.save(new Vehiculo(5L,"DESCRIPCION5","MODELO2","COLOR5","MOTOR5",new BigDecimal(5555)));
		this.repository.save(new Vehiculo(6L,"DESCRIPCION6","MODELO2","COLOR6","MOTOR6",new BigDecimal(4444)));


		// fetch all customers
		System.out.println("Vehiculos found with findAll():");
		System.out.println("-------------------------------");
		for (Vehiculo vehiculo : this.repository.findAll()) {
			System.out.println(vehiculo.toString());
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Vehiculo found with findById(1L):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findById(1L));
		System.out.println();

		System.out.println("Vehiculos found with findByModelo('MODELO1'):");
		System.out.println("--------------------------------");
		for (Vehiculo vehiculo : this.repository.findByModelo("MODELO1")) {
			System.out.println(vehiculo);
		}
		System.out.println();

		System.out.println("Vehiculos found with findAll():");
		System.out.println("--------------------------------");
		for (Vehiculo vehiculo : this.repository.findAll()) {
			System.out.println(vehiculo);
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MongoAplication.class, args);
	}
	
}