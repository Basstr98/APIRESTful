package com.ticarum.apirest.dominio;

import java.util.List;
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
	
	@Column(nullable=true)
	private Double valor;
	
	@OneToMany(mappedBy="sensor",cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Historico> historicoValores;
	
	public Sensor() {}
	
	public Sensor(TipoSensor tipo, String magnitud) {
		this.tipo = tipo;
		this.magnitud = magnitud;
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
	
	public List<Historico> getHistoricoValores() {
		return historicoValores;
	}
	
}
