package com.ticarum.apirest.aplicacion;

import java.time.LocalDateTime;

import com.ticarum.apirest.dominio.Sensor;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HistoricoDto {

	private Long id;
	
	@NotBlank(message="Sensor no valido: sensor vacio")
	private Sensor sensor;
	
	@NotBlank(message="Valor no valido: valor vacio")
	private Double valor;
	
	@NotBlank(message="Fecha no valida: fecha vacia")
	private LocalDateTime fecha;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
}
