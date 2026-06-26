package ar.unlam.edu.centrocarcelario.data.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CentroPenitenciario {

	private HashSet<Recluso> reclusos;
	private HashSet<Guardia> guardias;

	private HashMap<String, Familiar> familiares;

	private HashMap<String, HashSet<AutorizacionVisita>> autorizaciones;

	private HashMap<String, List<Turno>> historialTurnos;

	private HashMap<String, TreeSet<Turno>> agendaDiaria;

	public CentroPenitenciario() {

		this.reclusos = new HashSet<>();
		this.guardias = new HashSet<>();

		this.familiares = new HashMap<>();

		this.autorizaciones = new HashMap<>();

		this.historialTurnos = new HashMap<>();

		this.agendaDiaria = new HashMap<>();
	}

	public HashSet<Recluso> getReclusos() {
		return reclusos;
	}

	public void setReclusos(HashSet<Recluso> reclusos) {
		this.reclusos = reclusos;
	}

	public HashSet<Guardia> getGuardias() {
		return guardias;
	}

	public void setGuardias(HashSet<Guardia> guardias) {
		this.guardias = guardias;
	}

	public HashMap<String, Familiar> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(HashMap<String, Familiar> familiares) {
		this.familiares = familiares;
	}

	public HashMap<String, HashSet<AutorizacionVisita>> getAutorizaciones() {
		return autorizaciones;
	}

	public void setAutorizaciones(HashMap<String, HashSet<AutorizacionVisita>> autorizaciones) {
		this.autorizaciones = autorizaciones;
	}

	public HashMap<String, List<Turno>> getHistorialTurnos() {
		return historialTurnos;
	}

	public void setHistorialTurnos(HashMap<String, List<Turno>> historialTurnos) {
		this.historialTurnos = historialTurnos;
	}

	public HashMap<String, TreeSet<Turno>> getAgendaDiaria() {
		return agendaDiaria;
	}

	public void setAgendaDiaria(HashMap<String, TreeSet<Turno>> agendaDiaria) {
		this.agendaDiaria = agendaDiaria;
	}
	
}
