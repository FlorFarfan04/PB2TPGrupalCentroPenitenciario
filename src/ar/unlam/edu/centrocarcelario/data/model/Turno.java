package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

	private LocalDate fechaDeVisita;
	private LocalTime horarioDeVisita;
	private Recluso recluso;
	private Persona visitante;

	
	public Turno(LocalDate fechaDeVisita, LocalTime horarioDeVisita, Recluso recluso, Persona visitante,
			Guardia guardiaAsignado) {
		super();
		this.fechaDeVisita = fechaDeVisita;
		this.horarioDeVisita = horarioDeVisita;
		this.recluso = recluso;
		this.visitante = visitante;
	}
	
}
