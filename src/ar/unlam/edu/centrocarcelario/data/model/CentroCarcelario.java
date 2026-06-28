package ar.unlam.edu.centrocarcelario.data.model;

import java.util.HashSet;

public class CentroCarcelario {
	
	private String nombre;
	private HashSet<Recluso> listaDeReclusos;
	private HashSet<Guardia> guardias;
	private HashSet<Familiar> familiares;
	
	public CentroCarcelario(String nombre) {
		this.nombre = nombre;
		this.listaDeReclusos = new HashSet<Recluso>();
		this.guardias = new HashSet<Guardia>();
		this.familiares = new HashSet<Familiar>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Recluso> getListaDeReclusos() {
		return listaDeReclusos;
	}

	public void setListaDeReclusos(HashSet<Recluso> listaDeReclusos) {
		this.listaDeReclusos = listaDeReclusos;
	}

	public HashSet<Guardia> getGuardias() {
		return guardias;
	}

	public void setGuardias(HashSet<Guardia> guardias) {
		this.guardias = guardias;
	}

	public HashSet<Familiar> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(HashSet<Familiar> familiares) {
		this.familiares = familiares;
	}
	
}
