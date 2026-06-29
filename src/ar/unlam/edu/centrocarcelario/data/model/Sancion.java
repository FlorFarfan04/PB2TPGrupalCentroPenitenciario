package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public class Sancion extends RegistroDisciplinario{

	private Integer gravedad;

	public Sancion(LocalDate fecha, String descripcion, Integer gravedad) {
		super(fecha, descripcion);

		this.gravedad = gravedad;
	}

	public Integer getGravedad() {
		return gravedad;
	}

	public void setGravedad(Integer gravedad) {
		this.gravedad = gravedad;
	}
}
