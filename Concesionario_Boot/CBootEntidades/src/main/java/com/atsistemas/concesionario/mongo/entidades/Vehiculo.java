package com.atsistemas.concesionario.mongo.entidades;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Vehiculo {
	
	@Id
	private Long id;

//	private PedidoJPA pedido;

	private String descripcion;
	
	private String modelo;
	
	private String color;

	private String motor;
	
	private BigDecimal precio;

	public Vehiculo() {
		
	}

	public Vehiculo(Long id, String descripcion, String modelo, String color, String motor, BigDecimal precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.color = color;
		this.motor = motor;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", descripcion=" + descripcion + ", modelo=" + modelo + ", color=" + color
				+ ", motor=" + motor + ", precio=" + precio + "]";
	}

}


