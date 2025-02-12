package com.ticarum.apirest.infraestructura;

import java.util.List;
import java.util.Optional;

import com.ticarum.apirest.dominio.Sensor;
import com.ticarum.apirest.dominio.TipoSensor;
import com.ticarum.rest.application.dtos.AlumnoSimpleDto;
import com.ticarum.rest.application.entities.Alumno;

public interface SensorService {
	public Optional<Sensor> getSensor(Long id);
	public Optional<Alumno> getAlumno(AlumnoSimpleDto alumnoDto);
	public Optional<Sensor> getSensor(TipoSensor tipo);
	public List<Sensor> listar();
}
