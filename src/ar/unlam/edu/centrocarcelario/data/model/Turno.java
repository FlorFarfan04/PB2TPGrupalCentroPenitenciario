package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDateTime;

public class Turno implements Comparable<Turno>{
	private Integer idTurno;
	private Familiar visitante;
	private String dniRecluso;
	private LocalDateTime fechaHora;
	private Guardia guardia;
	private EstadoSolicitud estado;

	public Turno(Integer idTurno, Familiar visitante, String dniRecluso, LocalDateTime fechaHora,
			Guardia guardia, EstadoSolicitud estado) {

		this.idTurno = idTurno;
		this.visitante = visitante;
		this.dniRecluso = dniRecluso;
		this.fechaHora = fechaHora;
		this.guardia = guardia;
		this.estado = estado;
	}

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public Familiar getVisitante() {
		return visitante;
	}

	public void setVisitante(Familiar visitante) {
		this.visitante = visitante;
	}

	public String getDniRecluso() {
		return dniRecluso;
	}

	public void setDniRecluso(String dniRecluso) {
		this.dniRecluso = dniRecluso;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Guardia getGuardia() {
		return guardia;
	}

	public void setGuardia(Guardia guardia) {
		this.guardia = guardia;
	}

	public EstadoSolicitud getEstado() {
		return estado;
	}

	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}
	@Override
	public int compareTo(Turno otro) {
		return this.fechaHora.compareTo(otro.fechaHora);
	}
}
