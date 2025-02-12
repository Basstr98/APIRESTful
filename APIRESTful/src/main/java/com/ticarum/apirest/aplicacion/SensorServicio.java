package com.ticarum.apirest.aplicacion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ticarum.apirest.dominio.Historico;
import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.dominio.TipoSensor;

public class SensorServicio implements com.ticarum.apirest.infraestructura.SensorServicio{

	@Override
	public SensorDto toDto(Sensor sensor, Class<? extends SensorDto> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor toEntidad(SensorDto sensorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor registrar(SensorDto sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Sensor> getSensor(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Sensor> getSensor(SensorDto sensorDto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Sensor> getSensor(TipoSensor tipo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Historico> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historico registrarHistorico(Sensor sensor, Historico historico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tieneHistorico(Sensor sensor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double getValor(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Double> getMedia(Sensor sensor, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
