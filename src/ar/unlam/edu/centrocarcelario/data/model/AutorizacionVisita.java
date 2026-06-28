package ar.unlam.edu.centrocarcelario.data.model;

public class AutorizacionVisita {

	private Integer dniFamiliar;
	private Parentesco parentesco;
	
	public AutorizacionVisita(Integer dniFamiliar, Parentesco parentesco) {
		this.dniFamiliar = dniFamiliar;
		this.parentesco = parentesco;
	}

	public Integer getDniFamiliar() {
		return dniFamiliar;
	}

	public void setDniFamiliar(Integer dniFamiliar) {
		this.dniFamiliar = dniFamiliar;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}
	
}
