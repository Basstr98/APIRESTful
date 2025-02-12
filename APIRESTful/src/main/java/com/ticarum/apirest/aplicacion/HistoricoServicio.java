package com.ticarum.apirest.aplicacion;

import java.time.LocalDateTime;
import java.util.Optional;

import com.ticarum.apirest.dominio.Historico;
import com.ticarum.apirest.dominio.Sensor;

public class HistoricoServicio implements com.ticarum.apirest.infraestructura.HistoricoServicio{

	@Override
	public HistoricoDto toDto(Historico historico, Class<? extends HistoricoDto> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historico toEntidad(HistoricoDto historicoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historico registrar(HistoricoDto historicoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Historico> getHistorico(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Sensor> getSensor(Historico historico) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public LocalDateTime getFecha(Historico historico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getValor(Historico historico) {
		// TODO Auto-generated method stub
		return null;
	}

}
