package ar.unlam.edu.centrocarcelario.data.model;

import java.util.Objects;

public class AutorizacionVisita {
	private String dniFamiliar;
	private TipoParentesco parentesco;
	
	public AutorizacionVisita(String dniFamiliar, TipoParentesco parentesco) {

		this.dniFamiliar = dniFamiliar;
		this.parentesco = parentesco;
	}

	public String getDniFamiliar() {
		return dniFamiliar;
	}

	public void setDniFamiliar(String dniFamiliar) {
		this.dniFamiliar = dniFamiliar;
	}

	public TipoParentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(TipoParentesco parentesco) {
		this.parentesco = parentesco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dniFamiliar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AutorizacionVisita))
			return false;
		AutorizacionVisita other = (AutorizacionVisita) obj;
		return Objects.equals(dniFamiliar, other.dniFamiliar);
	}
	
}
