package tablerotest;

import ErroresYExcepciones.*;
import equipo.Equipo;
import Unidad.Unidad;
import celda.Celda;
import equipo.Equipo;
import tablero.Tablero;
import Unidad.Soldado;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TableroTest extends TestCase {

	public void test00SeTableroCreaTableroYLaReferenciaNoEsVacia() {
		Equipo equipoDeEugenio = new Equipo("Eugenio", 20);
		Equipo equipoDePepe = new Equipo("Pepe", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDePepe, equipoDeEugenio);
		Assert.assertNotNull(nuevoTablero);
	}

	public void test01TableroSoloSePuedeColocarUnaUnidadEnElSectorAliado() throws CeldaNoEstaEnElTablero {
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

	public void test02TableroSeColocaUnaUnidadEnElSectorQueCorresponde() throws CeldaNoEstaEnElTablero, CeldaNoTieneUnidad {
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();
		try {
			nuevoTablero.colocarUnidad(unSoldado, 17, 17);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			tableroSectorInvalido.printStackTrace();
		}

		try {
			Assert.assertEquals(nuevoTablero.verUnidad(17, 17), unSoldado);
		} catch (CeldaNoEstaEnElTablero celdaNoEstaEnElTablero) {
			fail("No se coloco la unidad.");
		}
	}

	public void test03TableroSePuedeCambiarElSectorQueEstaPoniendoLasFichas() throws CeldaNoEstaEnElTablero {
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();
		boolean seCambioDeSector = true;

		try {
			nuevoTablero.colocarUnidad(unSoldado, 17, 17);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			seCambioDeSector = false;
		}
		nuevoTablero.cambiarSector();
		try {
			nuevoTablero.colocarUnidad(unSoldado, 0, 0);
		} catch (TableroSectorInvalido excepcion) {
			seCambioDeSector = false;
		}
		Assert.assertTrue(seCambioDeSector);
	}

	public void test04TableroSePuedeMoverUnaUnidadAUnaCasillaAdyacente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad {
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();

		nuevoTablero.cambiarSector();

		nuevoTablero.colocarUnidad(unSoldado, 2, 2);

		nuevoTablero.moverUnidad(2, 2, 2, 3);

		assertEquals(nuevoTablero.verUnidad(2, 3), unSoldado);

	}

	public void test05TableroAlMoverUnaUnidadLaCeldaQuedaVacia() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad {
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = new Soldado();

		nuevoTablero.cambiarSector();

		nuevoTablero.colocarUnidad(unSoldado, 2, 2);


		try{
			nuevoTablero.moverUnidad(2, 2, 2, 3);
			Unidad unidadVacia = nuevoTablero.verUnidad(2 , 2);
			fail("El test no tiro la excepcion CeldaNoTieneUnidad");
		}catch(CeldaNoTieneUnidad e){
		}

	}
}