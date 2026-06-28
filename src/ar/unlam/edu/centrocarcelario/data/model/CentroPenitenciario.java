package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class CentroPenitenciario {

	private HashSet<Recluso> reclusos;
	private HashSet<Guardia> guardias;

	private HashMap<Integer, Familiar> familiares;

	private HashMap<Integer, HashSet<AutorizacionVisita>> autorizaciones;

	private HashMap<Integer, HashSet<Turno>> historialTurnos;

	private HashMap<LocalDate, TreeSet<Turno>> agendaDiaria;

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

	public HashMap<Integer, Familiar> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(HashMap<Integer, Familiar> familiares) {
		this.familiares = familiares;
	}

	public HashMap<Integer, HashSet<AutorizacionVisita>> getAutorizaciones() {
		return autorizaciones;
	}

	public void setAutorizaciones(HashMap<Integer, HashSet<AutorizacionVisita>> autorizaciones) {
		this.autorizaciones = autorizaciones;
	}

	public HashMap<Integer, HashSet<Turno>> getHistorialTurnos() {
		return historialTurnos;
	}

	public void setHistorialTurnos(HashMap<Integer, HashSet<Turno>> historialTurnos) {
		this.historialTurnos = historialTurnos;
	}

	public HashMap<LocalDate, TreeSet<Turno>> getAgendaDiaria() {
		return agendaDiaria;
	}

	public void setAgendaDiaria(HashMap<LocalDate, TreeSet<Turno>> agendaDiaria) {
		this.agendaDiaria = agendaDiaria;
	}
	
}
