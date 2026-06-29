package ar.unlam.edu.centrocarcelario.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import ar.unlam.edu.centrocarcelario.data.model.*;
import ar.unlam.edu.centrocarcelario.data.model.CentroCarcelario;
import ar.unlam.edu.centrocarcelario.data.model.CupoExcedidoException;
import ar.unlam.edu.centrocarcelario.data.model.EstadoSolicitud;
import ar.unlam.edu.centrocarcelario.data.model.Familiar;
import ar.unlam.edu.centrocarcelario.data.model.FamiliarNoAutorizadoException;
import ar.unlam.edu.centrocarcelario.data.model.FamiliarNoEncontradoException;
import ar.unlam.edu.centrocarcelario.data.model.Guardia;
import ar.unlam.edu.centrocarcelario.data.model.GuardiaNoDisponibleException;
import ar.unlam.edu.centrocarcelario.data.model.Parentesco;
import ar.unlam.edu.centrocarcelario.data.model.Turno;
import ar.unlam.edu.centrocarcelario.data.model.TurnoNoDisponibleException;
import ar.unlam.edu.centrocarcelario.data.model.Persona;
import ar.unlam.edu.centrocarcelario.data.model.Recluso;
import ar.unlam.edu.centrocarcelario.data.model.ReclusoNoEncontradoException;

public class CentroCarcelarioTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
	// GIVEN
	
	Integer dni = 1;
	String nombre = "Pablo";
	String apellido = "Gomez";
	LocalDate fdn = LocalDate.of(2000, 12, 12);
	Persona p = new Recluso(dni, nombre, apellido, fdn,10.5,1.0);
	// WHEN
	// THEN
	assertEquals(0, 0);
    }

///**
// * TEST 1: Registro de Reclusos y Control de Duplicados
// * Objetivo: Verificar que al registrar dos reclusos con el mismo idRecluso,
// * el sistema no permita duplicados y lance la excepción
// * ReclusoDuplicadoException o mantenga un único registro.
// */
//@Test
//public void queNoSePuedanRegistrarDosReclusosConElMismoId() {
//	
//}
///**
// * TEST 2: Registro de Familiares y Autorización de Visitas
// * Objetivo: Verificar que un familiar registrado pueda ser autorizado para
// * visitar a un recluso determinado, almacenando correctamente el parentesco
// * mediante una AutorizacionVisita.
// */
//@Test
//public void queSePuedaRegistrarUnFamiliarYAutorizarloParaVisitarUnRecluso() {
//	
//}
/**
 * TEST 3: Intento de Autorizar un Familiar No Registrado
 * Objetivo: Validar que al intentar autorizar a un familiar inexistente,
 * el sistema lance la excepción FamiliarNoEncontradoException.
 */
@Test(expected = FamiliarNoEncontradoException.class)
public void queAlAutorizarUnFamiliarNoRegistradoSeLanceFamiliarNoEncontradoException() throws FamiliarNoEncontradoException {
	CentroCarcelario carcel = new CentroCarcelario();

	Familiar familiar1 = new Familiar(11111111, "pedro", "perez", LocalDate.of(1999, 11, 11), 1121541256);

	Recluso recluso = new Recluso(12345678, "mario", "dominguez", LocalDate.of(1950, 1, 1), 10.5, 1.0);
	carcel.registrarRecluso(recluso);

	carcel.registrarAutorizacion(recluso.getDni(), familiar1.getDni(), Parentesco.HERMANO);
}

///**
// * TEST 4: Solicitud de Turno con Familiar Autorizado
// * Objetivo: Verificar que un familiar previamente autorizado pueda solicitar
// * un turno de visita y que éste sea registrado con estado
// * EstadoSolicitud.APROBADA.
// */
//@Test
//public void queSePuedaSolicitarUnTurnoConUnFamiliarAutorizado() {
//	
//}
/**
 * TEST 5: Solicitud de Turno con Familiar No Autorizado
 * Objetivo: Comprobar que al solicitar una visita con un familiar que no se
 * encuentra autorizado para ese recluso, el sistema lance la excepción
 * FamiliarNoAutorizadoException.
 */
@Test(expected = FamiliarNoAutorizadoException.class)
public void queAlSolicitarUnTurnoConUnFamiliarNoAutorizadoSeLanceFamiliarNoAutorizadoException() throws FamiliarNoAutorizadoException, TurnoNoDisponibleException, CupoExcedidoException, ReclusoNoEncontradoException, GuardiaNoDisponibleException, FamiliarNoEncontradoException {
	CentroCarcelario carcel = new CentroCarcelario();

	Recluso recluso1 = new Recluso(11111111, "juan", "perez", LocalDate.of(1999, 12, 11), 10.2, 1.0);
	Familiar familiar1 = new Familiar(22222222, "pedro", "perez", LocalDate.of(1999, 11, 11), 1121541256);
	Familiar familiar2 = new Familiar(22222232, "pablo", "perez", LocalDate.of(1979, 11, 11), 1121541656);

	carcel.registrarFamiliar(familiar1);
	carcel.registrarRecluso(recluso1);

	carcel.registrarAutorizacion(recluso1.getDni(), familiar1.getDni(), Parentesco.HERMANO);

	Guardia guardia = new Guardia(12345678, "carlos", "rodriguez", LocalDate.of(1981, 5, 2), "Manaña");
	carcel.registrarGuardia(guardia);

	Turno turno = new Turno(1, familiar2, 11111111, LocalDateTime.of(2026, 05, 11, 10, 30), guardia,EstadoSolicitud.RECHAZADA);

	carcel.solicitarTurno(turno);
}
///**
// * TEST 6: Control de Cupo Diario Máximo de Visitas
// * Objetivo: Verificar que al superar el límite permitido de visitas para una
// * fecha determinada, el sistema lance la excepción
// * CupoExcedidoException.
// */
//@Test(expected = CupoExcedidoException.class)
//public void queNoSePuedanSuperarLosCuposDiariosDeVisitas() {
//	
//}
///**
// * TEST 7: Restricción de Doble Turno para un Recluso
// * Objetivo: Validar que un mismo recluso no pueda tener dos turnos de visita
// * en la misma fecha y horario, lanzando la excepción
// * TurnoNoDisponibleException.
// */
//@Test(expected = TurnoNoDisponibleException.class)
//public void queNoSePuedanRegistrarDosTurnosParaElMismoReclusoEnElMismoHorario() {
//	
//}
/**
 * TEST 8: Asignación Automática de Guardia
 * Objetivo: Verificar que al procesar un turno sin especificar guardia,
 * el sistema asigne automáticamente uno disponible y registre el turno
 * correctamente.
 */
@Test
public void queSePuedaAsignarAutomaticamenteUnGuardiaDisponibleAlProcesarUnTurno() throws FamiliarNoEncontradoException, FamiliarNoAutorizadoException, TurnoNoDisponibleException, CupoExcedidoException, ReclusoNoEncontradoException, GuardiaNoDisponibleException {
	CentroCarcelario carcel = new CentroCarcelario();

	Recluso recluso1 = new Recluso(11111111, "juan", "perez", LocalDate.of(1999, 12, 11), 10.2, 1.0);
	Familiar familiar1 = new Familiar(22222222, "pedro", "perez", LocalDate.of(1999, 11, 11), 1121541256);

	carcel.registrarFamiliar(familiar1);
	carcel.registrarRecluso(recluso1);

	carcel.registrarAutorizacion(11111111,22222222, Parentesco.HERMANO);

	Turno turno = new Turno(1, familiar1, 11111111, LocalDateTime.of(2026, 05, 11, 10, 30), null,EstadoSolicitud.APROBADA);

	assertTrue(carcel.solicitarTurno(turno));
}
///**
// * TEST 9: Validación de Disponibilidad de Guardia
// * Objetivo: Comprobar que si se intenta asignar un guardia ocupado en una
// * fecha y horario determinados, el sistema lance la excepción
// * GuardiaNoDisponibleException.
// */
//
//@Test(expected = GuardiaNoDisponibleException.class)
//public void queAlAsignarUnGuardiaOcupadoSeLanceGuardiaNoDisponibleException() {
//	
//}
///**
// * TEST 10: Flujo Completo de un Turno
// * Objetivo: Verificar que un turno inicialmente registrado con estado
// * EstadoSolicitud.APROBADA pueda ser completado correctamente y pase al
// * estado EstadoSolicitud.COMPLETADA.
// */
//@Test
//public void queUnTurnoAprobadoSePuedaCompletarCorrectamente() {
//	
//}
/**
 * TEST 11: Cálculo de Condena con Historial Disciplinario
 * Objetivo: Verificar que al agregar sanciones y registros de buena conducta
 * al historial de un recluso, el cálculo de la condena se modifique según
 * las reglas establecidas por la implementación de CalculableCondena.
 */
@Test
public void queSePuedaCalcularLaCondenaConsiderandoSancionesYBuenasConductas() {
	CentroCarcelario carcel = new CentroCarcelario();

	Recluso recluso1 = new Recluso(11111111, "juan", "perez", LocalDate.of(1999, 12, 11), 10.2, 1.0);
	
	carcel.registrarRecluso(recluso1);
	
	Sancion sancion=new Sancion(LocalDate.of(2026, 1, 3),"pelea en grupo",7);
	Sancion sancion2=new Sancion(LocalDate.of(2026, 1, 5),"pelea en grupo",7);
	
	carcel.agregarSancion(recluso1,sancion);
	carcel.agregarSancion(recluso1,sancion2);
	
	assertEquals(12.2,carcel.calcularCondena(recluso1),0.1);
}
///**
// * TEST 12: Ordenamiento Cronológico de Turnos
// * Objetivo: Validar que los turnos almacenados en un TreeSet se ordenen
// * automáticamente por fecha y hora, respetando el criterio definido por
// * Comparable.
// */
//@Test
//public void queLosTurnosSeMantenganOrdenadosCronologicamente() {
//	
//}
///**
// * TEST 13: Ordenamiento Cronológico del Historial Disciplinario
// * Objetivo: Verificar que los registros disciplinarios (sanciones y buenas
// * conductas) se mantengan ordenados cronológicamente dentro del TreeSet
// * asociado al recluso.
// */
//@Test
//public void queLosRegistrosDisciplinariosSeMantenganOrdenadosCronologicamente() {
//	
//}
///**
// * TEST 14: Consulta del Historial de Visitas de un Recluso
// * Objetivo: Verificar que el sistema pueda recuperar correctamente todos los
// * turnos asociados a un recluso determinado mediante la estructura de
// * historial de turnos.
// */
//@Test
//public void queSePuedaObtenerElHistorialDeVisitasDeUnRecluso() {
//	
//}
///**
// * TEST 15: Consulta de Agenda Diaria Ordenada por Hora
// * Objetivo: Validar que la agenda diaria devuelta por el sistema contenga
// * todos los turnos correspondientes a una fecha determinada y que éstos se
// * encuentren ordenados de forma ascendente según la hora de la visita.
// */
//@Test
//public void queSePuedaObtenerLaAgendaDiariaOrdenadaPorHora() {
//	
//}
///**
// * TEST 16: Excepción por Recluso Inexistente
// * Objetivo: Validar que al intentar buscar o realizar una operación sobre un
// * recluso que no se encuentra registrado en el sistema, se lance la excepción
// * ReclusoNoEncontradoException.
// */
//@Test(expected = ReclusoNoEncontradoException.class)
//public void queAlBuscarUnReclusoInexistenteSeLanceReclusoNoEncontradoException() {
//	
//}
///**
// * TEST 17: Excepción por Guardia Inexistente
// * Objetivo: Verificar que al intentar asignar o consultar un guardia que no
// * fue previamente registrado, el sistema lance la excepción
// * GuardiaNoEncontradoException.
// */
//@Test(expected = GuardiaNoEncontradoException.class)
//public void queAlBuscarUnGuardiaInexistenteSeLanceGuardiaNoEncontradoException() {
//	
//}
///**
// * TEST 18: Consulta de Familiares Autorizados
// * Objetivo: Comprobar que al consultar los familiares autorizados de un
// * recluso, el sistema devuelva correctamente todas las autorizaciones
// * registradas junto con el parentesco correspondiente.
// */
//@Test
//public void queSePuedanObtenerLosFamiliaresAutorizadosDeUnRecluso() {
//	
//}
//
/**
 * TEST 19: Cálculo de Condena para un Recluso Temporal
 * Objetivo: Verificar que un ReclusoTemporal calcule correctamente su condena
 * considerando la condena base, los tipos de crimen asociados y las
 * modificaciones producidas por sanciones y buenas conductas.
 */
@Test
public void queUnReclusoTemporalCalculeCorrectamenteSuCondena() {
	CentroCarcelario carcel = new CentroCarcelario();
	Recluso recluso = new Recluso( 11111111,"Juan","Perez",LocalDate.of(1999,12,11),10.0, 1.0);
	
	carcel.registrarRecluso(recluso);

	recluso.getListaTipoCrimen().add(TipoCrimen.ROBO);
	recluso.calcularTipoRecluso();
	
	Sancion sancion =new Sancion(LocalDate.of(2026, 10, 10),"Pelea",7);
	Sancion sancion2 =new Sancion(LocalDate.of(2026, 12, 12),"Pelea",7);
	Sancion sancion3 =new Sancion(LocalDate.of(2026, 11, 12),"Pelea",7);

	carcel.agregarSancion(recluso,sancion);
	carcel.agregarSancion(recluso,sancion2);
	carcel.agregarSancion(recluso,sancion3);
	
	Double condena = carcel.calcularCondena(recluso);
	
	assertEquals(15,condena,0.1);
}
///**
// * TEST 20: Evaluación de Revisión de Condena para un Recluso Perpetuo
// * Objetivo: Comprobar que un ReclusoPerpetuo pueda ser evaluado para una
// * revisión de condena según las reglas establecidas y las condiciones de
// * comportamiento registradas en su historial disciplinario.
// */
//@Test
//public void queUnReclusoPerpetuoPermitaEvaluarLaRevisionDeSuCondena() {
//	
//}
}