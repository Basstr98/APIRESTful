package com.ticarum.apirest.aplicacion;

import com.ticarum.apirest.dominio.TipoSensor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorDto {

	private Long id;
	
	@NotBlank(message="Tipo de sensor no valido: tipo vacio")
	@Size(max = 20, message = "Tipo de sensor no valido: No pude tener mas de 20 caracteres de longitud")
	private TipoSensor tipo;
	
	@NotBlank(message="Magnitud no valida: magnitud vacia")
	@Size(max = 5, message = "Magnitud de sensor no valida: No pude tener mas de 5 caracteres de longitud")
	private String magnitud;
	
	@NotBlank(message="Valor no valido: valor vacio")
	private double valor;
	
	private double media;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public TipoSensor getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoSensor tipo) {
		this.tipo = tipo;
	}
	
	public String getMagnitud() {
		return magnitud;
	}
	
	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getMedia() {
		return media;
	}
	
	public void setMedia(double media) {
		this.media = media;
	}
}
	
	
