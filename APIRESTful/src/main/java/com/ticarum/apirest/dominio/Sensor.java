package com.ticarum.apirest.dominio;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Sensor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=20)
	private TipoSensor tipo;
	
	@Column(nullable=false,length=5)
	private String magnitud;
	
	@Column(nullable=false)
	private Double valor;
	
	@Column(nullable=false)
	private Double media;
	
	@OneToMany(mappedBy="sensor",cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Historico> historicoValores;
	
	public Sensor() {}
	
	public Sensor(TipoSensor tipo, String magnitud, double valor) {
		this.tipo = tipo;
		this.magnitud = magnitud;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMagnitud() {
		return magnitud;
	}
	
	public TipoSensor getTipo() {
		return tipo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Set<Historico> getHistoricoValores() {
		return historicoValores;
	}
	
	public Double getMedia() {
		return media;
	}
	
	public void setMedia(Double media) {
		this.media = media;
	}
	
}
