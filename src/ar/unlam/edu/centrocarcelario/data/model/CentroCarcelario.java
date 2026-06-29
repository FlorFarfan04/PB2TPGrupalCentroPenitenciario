package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class CentroCarcelario {

	private HashSet<Recluso> reclusos;
	private HashSet<Guardia> guardias;

	private HashMap<Integer, Familiar> familiares;

	private HashMap<Integer, HashSet<AutorizacionVisita>> autorizaciones;

	private HashMap<Integer, HashSet<Turno>> historialTurnos;

	private HashMap<LocalDate, TreeSet<Turno>> agendaDiaria;

	private Integer cupoVisitas = 2;

	public CentroCarcelario() {

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

	public Guardia buscarGuardiaPorDni(Integer dniGuardia) throws GuardiaNoEncontradoException {
		for (Guardia guardia : guardias) {
			if (guardia.getDni().equals(dniGuardia)) {
				return guardia;
			}
		}
		throw new GuardiaNoEncontradoException();

	}

	public HashSet<Turno> getHistorialTurnosPorIdRecluso(Integer idRecluso) throws ReclusoNoEncontradoException {

		if (checkReclusoExiste(idRecluso) == null) {
			throw new ReclusoNoEncontradoException();

		} else if (historialTurnos.get(idRecluso) == null) {
			return new HashSet<Turno>();
		}
		return historialTurnos.get(idRecluso);

	}

	private Recluso checkReclusoExiste(Integer reclusoDni) {
		for (Recluso r : this.reclusos) {
			if (r.getDni().equals(reclusoDni)) {
				return r;
			}
		}
		return null;
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

	public void registrarRecluso(Recluso recluso) throws ReclusoDuplicadoException {

		if (this.reclusos.contains(recluso)) {
			throw new ReclusoDuplicadoException();
		} else {
			this.reclusos.add(recluso);
		}

	}

	public Boolean verificarQueUnFamiliarEsteAutorizado(Integer dniRecluso, Integer dniFamiliar) {
		HashSet<AutorizacionVisita> autorizacionesDelRecluso = autorizaciones.get(dniRecluso);

		if (autorizacionesDelRecluso == null) {
			return false;
		}

		for (AutorizacionVisita autorizacion : autorizacionesDelRecluso) {
			if (autorizacion.getDniFamiliar().equals(dniFamiliar)) {
				return true;
			}
		}

		return false;
	}

	public Familiar buscarFamiliarPorDni(Integer dnifamiliar) throws FamiliarNoEncontradoException {
		if (!this.familiares.containsKey(dnifamiliar)) {
			throw new FamiliarNoEncontradoException();
		}

		return this.familiares.get(dnifamiliar);
	}

	public void registrarFamiliar(Familiar familiar) {
		this.familiares.put(familiar.getDni(), familiar);

	}

	public void registrarGuardia(Guardia guardia) {
		guardias.add(guardia);
	}

	public Boolean registrarAutorizacion(Integer dniRecluso, Integer dniFamiliar, Parentesco parentesco)
			throws FamiliarNoEncontradoException {
		if (!familiares.containsKey(dniFamiliar)) {
			throw new FamiliarNoEncontradoException();
		}

		AutorizacionVisita autorizacion = new AutorizacionVisita(dniFamiliar, parentesco);

		if (!autorizaciones.containsKey(dniRecluso)) {
			autorizaciones.put(dniRecluso, new HashSet<>());
		}

		autorizaciones.get(dniRecluso).add(autorizacion);

		return true;
	}

	public Boolean checkDisponibilidadHorariaGuardia(LocalDateTime fyh, Guardia guardia) {

		TreeSet<Turno> turnosDelDia = this.agendaDiaria.get(fyh.toLocalDate());
		if (turnosDelDia == null) {
			return true;
		}

		for (Turno t : turnosDelDia) {

			Long ventanaDeTiempo = Math
					.abs(ChronoUnit.MINUTES.between(fyh.toLocalTime(), t.getFechaHora().toLocalTime()));

			if (t.getGuardia().getDni().equals(guardia.getDni()) && ventanaDeTiempo <= 30L) {
				return false;

			}

		}
		return true;
	}

	public Boolean checkCupoDiario(LocalDate fechaTurno) {

		if (!agendaDiaria.containsKey(fechaTurno)) {

			return true;
		}

		if (agendaDiaria.get(fechaTurno).size() + 1 > this.cupoVisitas) {

			return false;
		}

		return true;

	}

	public Boolean solicitarTurno(Turno turno) throws FamiliarNoAutorizadoException, TurnoNoDisponibleException,
			CupoExcedidoException, ReclusoNoEncontradoException, GuardiaNoDisponibleException {

		if (!checkDisponibilidadHorariaGuardia(turno.getFechaHora(), turno.getGuardia())) {

			throw new GuardiaNoDisponibleException();
		}

		if (turno.getGuardia() == null) {
			turno.setGuardia(new Guardia(99999999, "Matias", "Gomes", LocalDate.of(1995, 10, 10), "Flexible"));
		}

		if (!autorizaciones.containsKey(turno.getDniRecluso())) {
			throw new ReclusoNoEncontradoException();
		}

		HashSet<AutorizacionVisita> autorizados = autorizaciones.get(turno.getDniRecluso());

		boolean autorizado = false;

		for (AutorizacionVisita autorizacion : autorizados) {

			if (autorizacion.getDniFamiliar().equals(turno.getVisitante().getDni())) {
				autorizado = true;
				break;
			}
		}

		if (!autorizado) {
			throw new FamiliarNoAutorizadoException();
		}

		if (!checkCupoDiario(turno.getFechaHora().toLocalDate())) {

			throw new CupoExcedidoException();
		}

		if (!historialTurnos.containsKey(turno.getDniRecluso())) {
			historialTurnos.put(turno.getDniRecluso(), new HashSet<>());
		}
		historialTurnos.get(turno.getDniRecluso()).add(turno);

		LocalDate fecha = turno.getFechaHora().toLocalDate();
		if (agendaDiaria.get(fecha) == null) {
			TreeSet<Turno> nuevaEntrada = new TreeSet<Turno>();
			nuevaEntrada.add(turno);
			agendaDiaria.put(fecha, nuevaEntrada);
		} else {
			agendaDiaria.get(fecha).add(turno);
		}

		return true;

	}

	public void agregarBuenaConducta(Recluso recluso, BuenaConducta buenaConducta) {
		recluso.historialDisciplinario.add(buenaConducta);
	}

	public void agregarSancion(Recluso recluso1, Sancion sancion) {
		recluso1.historialDisciplinario.add(sancion);
	}

	public Double calcularCondena(Recluso recluso) {
		return recluso.calcularCondena();
	}

}
