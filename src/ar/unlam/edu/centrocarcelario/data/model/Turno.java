package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDateTime;

public class Turno {

	private Integer idTurno;
	private LocalDateTime fechaHora;
	private Recluso recluso;
	private Familiar visitante;
	private Guardia guardiaResponsable;
	private EstadoSolicitud estadoSolicitud;
	
	public Turno(Integer idTurno, LocalDateTime fechaHora, Recluso recluso, Familiar visitante,
			EstadoSolicitud estadoSolicitud) {
		this.idTurno = idTurno;
		this.fechaHora = fechaHora;
		this.recluso = recluso;
		this.visitante = visitante;
		this.estadoSolicitud = estadoSolicitud;
	}

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Recluso getRecluso() {
		return recluso;
	}

	public void setRecluso(Recluso recluso) {
		this.recluso = recluso;
	}

	public Familiar getVisitante() {
		return visitante;
	}

	public void setVisitante(Familiar visitante) {
		this.visitante = visitante;
	}

	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
}
