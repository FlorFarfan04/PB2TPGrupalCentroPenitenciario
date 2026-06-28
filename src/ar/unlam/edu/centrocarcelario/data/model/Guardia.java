package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public class Guardia extends Persona{
	private String turno;

	public Guardia(Integer dni, String nombre, String apellido, LocalDate fdn,String turno) {
		super(dni, nombre, apellido, fdn);
		// TODO Auto-generated constructor stub
		this.turno=turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}
