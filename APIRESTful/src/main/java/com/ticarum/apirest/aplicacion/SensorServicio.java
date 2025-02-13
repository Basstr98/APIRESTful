package com.ticarum.apirest.aplicacion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticarum.apirest.dominio.Historico;
import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.dominio.TipoSensor;

@Service
public class SensorServicio implements com.ticarum.apirest.infraestructura.SensorServicio{

	@Autowired
	com.ticarum.apirest.infraestructura.SensorRepositorio sensorRep;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public SensorDto toDto(Sensor sensor, Class<? extends SensorDto> c) {
		SensorDto dto = modelMapper.map(sensor, c);
		return dto;
	}	

	@Override
	public Sensor toEntidad(SensorDto sensorDto) {
		Sensor sensor = modelMapper.map(sensorDto, Sensor.class);
			if (sensor.getId() != null) {
				return sensor;
			}
		return null;
	}

	@Override
	public Sensor registrar(SensorDto sensorDto) {
		Sensor sensor = sensorRep.save(toEntidad(sensorDto));
		return sensor;
	}

	@Override
	public Optional<Sensor> getSensor(Long id) {
		return sensorRep.findById(id);
	}

	@Override
	public Optional<Sensor> getSensor(SensorDto sensorDto) {
		Optional<Sensor> sensor = sensorRep.getSensorByTipo(sensorDto.getTipo());
		return sensor;
	}

	@Override
	public Optional<Sensor> getSensor(TipoSensor tipo) {
		return sensorRep.getSensorByTipo(tipo);
	}

	@Override
	public List<Sensor> listar() {
		return sensorRep.findAll();
	}

	@Override
	public Historico registrarHistorico(Sensor sensor) {
		Historico historico = new Historico(sensor,sensor.getValor());
		sensor.getHistoricoValores().add(historico);
		return historico;
	}

	@Override
	public boolean tieneHistorico(Sensor sensor) {
		return !sensor.getHistoricoValores().isEmpty();
	}

	@Override
	public Double getValor(Sensor sensor) {
		return sensor.getValor();
	}

	@Override
	public OptionalDouble getMedia(Sensor sensor, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		OptionalDouble media = sensor.getHistoricoValores().stream()
				.filter(h -> !h.getFecha().isBefore(fechaInicio) && !h.getFecha().isAfter(fechaFin))
				.mapToDouble(Historico::getValor)
				.average(); 
		if (media.isPresent()) {
			return media;
		}
		return null;
	}

	@Override
	public void eliminarSensor(Sensor sensor) {
		sensorRep.delete(sensor);
		
	}

}
