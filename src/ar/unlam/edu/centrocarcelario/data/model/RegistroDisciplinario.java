package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public class RegistroDisciplinario implements Comparable<RegistroDisciplinario> {
	private LocalDate fecha;
	private String descripcion;

	public RegistroDisciplinario(LocalDate fecha, String descripcion) {
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int compareTo(RegistroDisciplinario otro) {

		return this.fecha.compareTo(otro.fecha);
	}
}
