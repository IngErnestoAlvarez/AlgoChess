package tablerotest;

import ErroresYExcepciones.TableroSectorInvalido;
import equipo.Equipo;
import unidad.Unidad;
import tablero.Tablero;
import unidad.Soldado;
import junit.framework.Assert;
import junit.framework.TestCase;


public class TableroTest extends TestCase {

	public void test00SeCreaTableroYLaReferenciaNoEsVacia() {
		Equipo equipoDeEugenio = new Equipo("Eugenio", 20);
		Equipo equipoDePepe = new Equipo("Pepe", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDePepe, equipoDeEugenio);
		Assert.assertNotNull(nuevoTablero);
	}

	public void test01SoloSePuedeColocarUnaUnidadEnElTableroAliado() {
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();
		try {
			nuevoTablero.colocarUnidad(unSoldado, 0, 0); // empieza poniendo el equipo de abajo.
			fail("No se lanzo la excepcion de sector invalido");
		} catch (TableroSectorInvalido excepcion) {
		}
	}

	public void test02SeColocaUnaUnidadEnElSectorQueCorresponde() {
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();
		try {
			nuevoTablero.colocarUnidad(unSoldado, 17,17);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			tableroSectorInvalido.printStackTrace();
		}
		Assert.assertEquals(nuevoTablero.verUnidad(17,17),unSoldado);
	}

	public void test03SePuedeCambiarElSectorQueEstaPoniendoLasFichas(){
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();
		boolean ok = true;
		try {
			nuevoTablero.colocarUnidad(unSoldado, 17,17);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			ok = false;
		}
		nuevoTablero.cambiarSector();
		try {
			nuevoTablero.colocarUnidad(unSoldado, 0, 0);
		} catch (TableroSectorInvalido excepcion) {
			ok = false;
		}
		Assert.assertTrue(ok);
	}
}