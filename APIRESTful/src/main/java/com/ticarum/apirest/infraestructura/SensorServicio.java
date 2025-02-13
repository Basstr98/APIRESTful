package com.ticarum.apirest.infraestructura;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import com.ticarum.apirest.aplicacion.SensorDto;
import com.ticarum.apirest.dominio.Historico;
import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.dominio.TipoSensor;

public interface SensorServicio {
	public SensorDto toDto(Sensor sensor, Class<? extends SensorDto> c);
	public Sensor toEntidad(SensorDto sensorDto);
	public Sensor registrar(SensorDto sensorDto);
	public Optional<Sensor> getSensor(Long id);
	public Optional<Sensor> getSensor(SensorDto sensorDto);
	public Optional<Sensor> getSensor(TipoSensor tipo);
	public List<Sensor> listar();
	public Historico registrarHistorico(Sensor sensor);
	public boolean tieneHistorico(Sensor sensor);
	public Double getValor(Sensor sensor);
	public OptionalDouble getMedia(Sensor sensor, LocalDateTime fechaInicio, LocalDateTime fechaFin);
	public void eliminarSensor(Sensor sensor);
}
