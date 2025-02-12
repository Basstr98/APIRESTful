package com.ticarum.apirest.infraestructura;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ticarum.apirest.aplicacion.SensorDto;
import com.ticarum.apirest.dominio.Historico;
import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.dominio.TipoSensor;
import com.ticarum.rest.application.dtos.AsignaturaSimpleDto;
import com.ticarum.rest.application.entities.Asignatura;
import com.ticarum.rest.application.entities.Grupo;

public interface SensorServicio {
	public SensorDto toDto(Sensor sensor, Class<? extends SensorDto> c);
	public Sensor toEntidad(SensorDto sensorDto);
	public Sensor registrar(SensorDto sensor);
	public Optional<Sensor> getSensor(Long id);
	public Optional<Sensor> getSensor(SensorDto sensorDto);
	public Optional<Sensor> getSensor(TipoSensor tipo);
	public List<Historico> listar();
	public Historico registrarHistorico(Sensor sensor, Historico historico);
	public boolean tieneHistorico(Sensor sensor);
	public Double getValor(Sensor sensor);
	public Optional<Double> getMedia(Sensor sensor, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
