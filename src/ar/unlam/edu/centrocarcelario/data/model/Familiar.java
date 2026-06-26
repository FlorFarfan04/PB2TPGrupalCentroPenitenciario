package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public class Familiar extends Persona{
	private Integer telefono;

	public Familiar(Integer dni, String nombre, String apellido, LocalDate fdn,Integer telefono) {
		super(dni, nombre, apellido, fdn);
		// TODO Auto-generated constructor stub
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	

}
