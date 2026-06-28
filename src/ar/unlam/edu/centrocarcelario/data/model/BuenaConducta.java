package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public class BuenaConducta extends RegistroDisciplinario {
	private Integer puntaje;

	public BuenaConducta(LocalDate fecha, String descripcion, Integer puntaje) {

		super(fecha, descripcion);

		this.puntaje = puntaje;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
}
