package tablerotest;

import ErroresYExcepciones.*;
import celda.Posicion;
import unidad.Unidad;
import equipo.*;
import celda.Celda;
import tablero.Tablero;
import unidad.Soldado;
import junit.framework.Assert;
import junit.framework.TestCase;

import static org.mockito.Mockito.mock;


public class TableroTest extends TestCase {

	public void test00SeTableroCreaTableroYLaReferenciaNoEsVacia() {
		Equipo equipoDeEugenio = mock(Equipo.class);
		Equipo equipoDePepe = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDePepe, equipoDeEugenio);
		Assert.assertNotNull(nuevoTablero);
	}

	public void test01TableroSoloSePuedeColocarUnaUnidadEnElSectorAliado() throws CeldaNoEstaEnElTablero {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion unaPosicion = new Posicion(1,1);
		try {
			nuevoTablero.colocarUnidad(unSoldado, unaPosicion); // empieza poniendo el equipo de abajo.
			fail("No se lanzo la excepcion de sector invalido");
		} catch (TableroSectorInvalido excepcion) {
		}
	}

	public void test02TableroSeColocaUnaUnidadEnElSectorQueCorresponde() throws CeldaNoEstaEnElTablero, CeldaNoTieneUnidad {
		Equipo equipoDeJorge = mock(Equipo.class); //nombre,puntos;
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion (17,17);
		try {
			//Sector Correcto
			nuevoTablero.colocarUnidad(unSoldado, posicionDeseada);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			tableroSectorInvalido.printStackTrace();
			fail("No tendria que lanzar esta excepcion");
		}

		try {
			Assert.assertEquals(nuevoTablero.verUnidad(posicionDeseada), unSoldado);
		} catch (CeldaNoEstaEnElTablero celdaNoEstaEnElTablero) {
			fail("Error al buscar la celda.");
		}
	}

	public void test03TableroSePuedeCambiarElSectorQueEstaPoniendoLasFichas() throws CeldaNoEstaEnElTablero {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		boolean seCambioDeSector = true;
		Posicion unaPosicion = new Posicion (17, 17);
		Posicion otraPosicion = new Posicion (1, 1);


		try {
			nuevoTablero.colocarUnidad(unSoldado, unaPosicion);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			seCambioDeSector = false;
		}
		nuevoTablero.cambiarSector();
		try {
			nuevoTablero.colocarUnidad(unSoldado, otraPosicion);
		} catch (TableroSectorInvalido excepcion) {
			seCambioDeSector = false;
		}
		Assert.assertTrue(seCambioDeSector);
	}

	public void test04TableroSePuedeMoverUnaUnidadAUnaCasillaAdyacente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion(2, 2);

		nuevoTablero.cambiarSector();

		nuevoTablero.colocarUnidad(unSoldado, posicionDeseada);

		nuevoTablero.moverUnidad(posicionDeseada, posicionDeseada.derecha());

		assertEquals(nuevoTablero.verUnidad(posicionDeseada.derecha()), unSoldado);

	}

	public void test05TableroAlMoverUnaUnidadLaCeldaQuedaVacia() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion (2, 2);


		nuevoTablero.cambiarSector();

		nuevoTablero.colocarUnidad(unSoldado, posicionDeseada);


		try{
			nuevoTablero.moverUnidad(posicionDeseada, posicionDeseada.derecha());
			Unidad unidadVacia = nuevoTablero.verUnidad(posicionDeseada);
			fail("El test no tiro la excepcion CeldaNoTieneUnidad");
		}catch(CeldaNoTieneUnidad e){
		}

	}

	public void test06TableroMoverUnaUnidadDondeNoHayUnidadLanzaExcepcion() throws NoSeEncontroLaCelda, CeldaYaTieneUnidad {
		Equipo equipoDeJorge = mock(Equipo.class); //nombre,puntos;
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionDeseada = new Posicion (1, 1);

		try{
			nuevoTablero.moverUnidad(posicionDeseada, posicionDeseada.derecha());
			fail("El test no tiro la excepcion CeldaNoTieneUnidad");
		}catch(CeldaNoTieneUnidad excepcion){
		}
	}


	public void test07TableroMoverUnaUnidadACeldaOcupada() throws CeldaNoTieneUnidad, NoSeEncontroLaCelda, TableroSectorInvalido, CeldaNoEstaEnElTablero {
		Equipo equipoDeJorge = mock(Equipo.class); //nombre,puntos;
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Unidad otroSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion (20, 20);

		nuevoTablero.colocarUnidad(unSoldado, posicionDeseada);
		nuevoTablero.colocarUnidad(otroSoldado, posicionDeseada.arriba());


		try{
			nuevoTablero.moverUnidad( posicionDeseada, posicionDeseada.arriba());
			fail("El test no tiro la excepcion CeldaYaTieneUnidad");
		}catch(CeldaYaTieneUnidad otraExcepcion) {
		}
	}
}