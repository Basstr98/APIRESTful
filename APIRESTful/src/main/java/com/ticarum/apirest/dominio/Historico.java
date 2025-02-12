package com.ticarum.apirest.dominio;

import java.time.LocalDateTime;
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
    private double valor;
	
	@Column(nullable = false)
    private LocalDateTime fecha;
	
	public Historico() {}
	
	public Historico(Sensor sensor, double valor) {
		this.sensor = sensor;
		this.valor = valor;
		this.fecha = LocalDateTime.now();
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
	
	public LocalDateTime getFecha() {
		return fecha;
	}
}
