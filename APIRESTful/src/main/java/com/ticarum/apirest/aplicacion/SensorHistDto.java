package com.ticarum.apirest.aplicacion;

import java.util.Set;


public class SensorHistDto extends SensorDto{

	private Set<HistoricoDto> historicos;

	public Set<HistoricoDto> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(Set<HistoricoDto> historicos) {
		this.historicos = historicos;
	}
}
