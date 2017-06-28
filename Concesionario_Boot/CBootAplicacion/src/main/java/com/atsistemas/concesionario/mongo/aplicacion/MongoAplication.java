package com.atsistemas.concesionario.mongo.aplicacion;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.atsistemas.concesionario.mongo.entidades.Vehiculo;
import com.atsistemas.concesionario.mongo.persistencia.VehiculoRepository;

@SpringBootApplication(scanBasePackages = { "com.atsistemas.concesionario.mongo.aplicacion", "com.atsistemas.concesionario.mongo.entidades", "com.atsistemas.concesionario.mongo.persistencia"})
@EnableMongoRepositories("com.atsistemas.concesionario.mongo.persistencia")
@EnableAutoConfiguration
public class MongoAplication implements CommandLineRunner {

	@Autowired
	private VehiculoRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Vehiculo(1L,"DESCRIPCION1","MODELO1","COLOR1","MOTOR1",new BigDecimal(9999)));
		this.repository.save(new Vehiculo(2L,"DESCRIPCION2","MODELO1","COLOR1","MOTOR2",new BigDecimal(8888)));


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

		System.out.println("Vehiculos found with findByModelo('MODELO1'):");
		System.out.println("--------------------------------");
		for (Vehiculo vehiculo : this.repository.findByModelo("MODELO1")) {
			System.out.println(vehiculo);
		}
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MongoAplication.class, args);
}
	
	
}
