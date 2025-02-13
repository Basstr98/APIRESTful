package com.ticarum.apirest.presentacion;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.apirest.infraestructura.SensorServicio;
import com.ticarum.rest.application.dtos.AlumnoDetailDto;
import com.ticarum.rest.application.exceptions.EntidadNoExisteException;
import com.ticarum.apirest.aplicacion.SensorDto;
import com.ticarum.apirest.aplicacion.SensorHistDto;
import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.infraestructura.HistoricoServicio;
@RestController
public class Controlador {
	
	@Autowired
	SensorServicio sensorServicio;
	
	@Autowired
	HistoricoServicio historicoServicio;
	
	@GetMapping("/sensores")
	public List<SensorDto> listarSensores() {
		List<Sensor> sensores = sensorServicio.listar();
		List<SensorDto> dtos = new LinkedList<SensorDto>();
		for(Sensor sensor : sensores) {
			SensorDto dto = sensorServicio.toDto(sensor, SensorDto.class);
			dtos.add(dto);
		}
		return dtos;
	}
	
	@GetMapping("/sensores/{id}")
	public SensorHistDto getSensorById(@PathVariable(name="id") String id) {
		return sensorServicio.getSensor(Long.parseLong(id)).map(sensor -> {
			SensorHistDto dto = (SensorHistDto) sensorServicio.toDto(sensor, SensorHistDto.class);
			dto.getHistoricos().forEach(h -> h.setSensor(null));
			return dto;
		}).orElseThrow(() -> new EntidadNoExisteException("No existe alumno con ID " + id));
	
	}
}
