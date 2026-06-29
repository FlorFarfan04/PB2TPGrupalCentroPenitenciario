package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Recluso extends Persona {

	private Double condenaBase;
	private Double factorConducta;

	List<TipoCrimen> listaTipoCrimen;
	TreeSet<RegistroDisciplinario> historialDisciplinario;

	private TipoRecluso tipoRecluso;

	public Recluso(Integer dni, String nombre, String apellido, LocalDate fdn, Double condenaBase,
			Double factorConducta) {
		super(dni, nombre, apellido, fdn);

		this.condenaBase = condenaBase;
		this.factorConducta = factorConducta;

		listaTipoCrimen = new ArrayList<TipoCrimen>();
		historialDisciplinario = new TreeSet<RegistroDisciplinario>();

	}
	
	
	public Double getCondenaBase() {
		return condenaBase;
	}

	public void setCondenaBase(Double condenaBase) {
		this.condenaBase = condenaBase;
	}

	public Double getFactorConducta() {
		return factorConducta;
	}

	public void setFactorConducta(Double factorConducta) {
		this.factorConducta = factorConducta;
	}

	public List<TipoCrimen> getListaTipoCrimen() {
		return listaTipoCrimen;
	}

	public void setListaTipoCrimen(List<TipoCrimen> listaTipoCrimen) {
		this.listaTipoCrimen = listaTipoCrimen;
	}

	public TreeSet<RegistroDisciplinario> getHistorialDisciplinario() {
		return historialDisciplinario;
	}


	public void setHistorialDisciplinario(TreeSet<RegistroDisciplinario> historialDisciplinario) {
		this.historialDisciplinario = historialDisciplinario;
	}


	public TipoRecluso getTipoRecluso() {
		return tipoRecluso;
	}

	public void setTipoRecluso(TipoRecluso tipoRecluso) {
		this.tipoRecluso = tipoRecluso;
	}

	public void calcularTipoRecluso() {

		if (this.listaTipoCrimen.contains(TipoCrimen.DELITO_LESA_HUMANIDAD)
				|| this.listaTipoCrimen.contains(TipoCrimen.CORRUPCION)
				|| this.listaTipoCrimen.contains(TipoCrimen.ASESINATO)
				|| this.condenaBase >= 50.0) {

			this.tipoRecluso = TipoRecluso.PERPETUO;
		} else {
			this.tipoRecluso = TipoRecluso.TEMPORAL;
		}
	}

	public Double calcularCondena() {
		Double condena = this.condenaBase;

		for (TipoCrimen crimen : listaTipoCrimen) {
			condena += 2.0;
		}

		for (RegistroDisciplinario registro : historialDisciplinario) {

			if (registro instanceof Sancion) {
				condena += 1;
			}
			if (registro instanceof BuenaConducta) {
				condena -= 0.5;
			}
		}
		return condena;
	}

}
