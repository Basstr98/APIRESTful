package com.ticarum.apirest.presentacion;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.apirest.infraestructura.SensorServicio;

import com.ticarum.apirest.aplicacion.SensorDto;
import com.ticarum.apirest.aplicacion.SensorHistDto;
import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.excepciones.NoExisteEntidadException;
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
		List<SensorDto> sdtos = new LinkedList<SensorDto>();
		for(Sensor sensor : sensores) {
			SensorDto sdto = sensorServicio.toDto(sensor, SensorDto.class);
			sdtos.add(sdto);
		}
		return sdtos;
	}
	
	@GetMapping("/sensores/{id}")
	public SensorHistDto getSensorById(@PathVariable(name="id") String id) {
		return sensorServicio.getSensor(Long.parseLong(id)).map(sensor -> {
			SensorHistDto sdto = (SensorHistDto) sensorServicio.toDto(sensor, SensorHistDto.class);
			sdto.getHistoricos().forEach(h -> h.setSensor(null));
			return sdto;
		}).orElseThrow(() -> new NoExisteEntidadException("No existe el sensor con ID " + id));
	
	}
}
