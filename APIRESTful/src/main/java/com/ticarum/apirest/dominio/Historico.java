package com.ticarum.apirest.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Historico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
	
	@Column(nullable = false)
    private Double valor;
	
	@Column(nullable = false)
    private String fecha;
	
	public Historico() {}
	
	public Historico(Sensor sensor, double valor) {
		this.sensor = sensor;
		this.valor = valor;
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		this.fecha = LocalDateTime.now().format(formato);
	}
	
	public Long getId() {
		return id;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getFecha() {
		return fecha;
	}
}
