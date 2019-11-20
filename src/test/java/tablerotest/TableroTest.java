package tablerotest;

import ErroresYExcepciones.*;
import celda.Posicion;
import unidad.*;
import equipo.*;
import celda.Celda;
import tablero.Tablero;
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

	public void test01TableroSoloSePuedeColocarUnaUnidadEnElSectorAliado() throws CeldaNoEstaEnElTablero, CeldaYaTieneUnidad {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion unaPosicion = new Posicion(1, 1);
		try {
			nuevoTablero.colocarUnidad(unSoldado, unaPosicion); // empieza poniendo el equipo de abajo.
			fail("No se lanzo la excepcion de sector invalido");
		} catch (TableroSectorInvalido excepcion) {
		}

	}

	public void test02TableroSeColocaUnaUnidadEnElSectorQueCorresponde() throws CeldaNoEstaEnElTablero, CeldaNoTieneUnidad, CeldaYaTieneUnidad {

		Equipo equipoDeJorge = mock(Equipo.class); //nombre,puntos;
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion(17, 17);
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

	public void test03TableroSePuedeCambiarElSectorQueEstaPoniendoLasFichas() throws CeldaNoEstaEnElTablero, CeldaYaTieneUnidad {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		boolean seCambioDeSector = true;
		Posicion unaPosicion = new Posicion(17, 17);
		Posicion otraPosicion = new Posicion(1, 1);


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

	public void test04TableroSePuedeMoverUnaUnidadAUnaCasillaAdyacente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, MovimientoInvalido {

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

	public void test05TableroAlMoverUnaUnidadLaCeldaQuedaVacia() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, MovimientoInvalido {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion(2, 2);


		nuevoTablero.cambiarSector();

		nuevoTablero.colocarUnidad(unSoldado, posicionDeseada);


		try {
			nuevoTablero.moverUnidad(posicionDeseada, posicionDeseada.derecha());
			Unidad unidadVacia = nuevoTablero.verUnidad(posicionDeseada);
			fail("El test no tiro la excepcion CeldaNoTieneUnidad");
		} catch (CeldaNoTieneUnidad e) {
		}

	}

	public void test06TableroMoverUnaUnidadDondeNoHayUnidadLanzaExcepcion() throws NoSeEncontroLaCelda, CeldaYaTieneUnidad, MovimientoInvalido {

		Equipo equipoDeJorge = mock(Equipo.class); //nombre,puntos;
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionDeseada = new Posicion(1, 1);

		try {
			nuevoTablero.moverUnidad(posicionDeseada, posicionDeseada.derecha());
			fail("El test no tiro la excepcion CeldaNoTieneUnidad");
		} catch (CeldaNoTieneUnidad excepcion) {
		}

	}


	public void test07TableroMoverUnaUnidadACeldaOcupada() throws CeldaNoTieneUnidad, NoSeEncontroLaCelda, TableroSectorInvalido, CeldaNoEstaEnElTablero, MovimientoInvalido, CeldaYaTieneUnidad {

		Equipo equipoDeJorge = mock(Equipo.class); //nombre,puntos;
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Unidad otroSoldado = mock(Soldado.class);
		Posicion posicionDeseada = new Posicion(12, 12);

		nuevoTablero.colocarUnidad(unSoldado, posicionDeseada);
		nuevoTablero.colocarUnidad(otroSoldado, posicionDeseada.arriba());


		try {
			nuevoTablero.moverUnidad(posicionDeseada, posicionDeseada.arriba());
			fail("El test no tiro la excepcion CeldaYaTieneUnidad");
		} catch (CeldaYaTieneUnidad otraExcepcion) {
		}

	}

	public void test08TableroBatallonHorizontalSeMueveVerticalmente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, MovimientoInvalido {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionCentro = new Posicion(11, 11);

		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoDeDerecha = mock(Soldado.class);
		Unidad soldadoDeIzquierda = mock(Soldado.class);

		nuevoTablero.colocarUnidad(soldadoDeDerecha, posicionCentro.derecha());
		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
		nuevoTablero.colocarUnidad(soldadoDeIzquierda, posicionCentro.izquierda());

		nuevoTablero.moverUnidad(posicionCentro, posicionCentro.arriba());

		Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionCentro.derecha().arriba()));
		Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionCentro.izquierda().arriba()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.arriba()));

		nuevoTablero.moverUnidad(posicionCentro.arriba(), posicionCentro);

		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro));
		Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionCentro.derecha()));
		Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionCentro.izquierda()));

	}

	public void test09TableroBatallonHorizontalSeMueveHorizontalmente() throws CeldaNoTieneUnidad, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, MovimientoInvalido, TableroSectorInvalido {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionCentro = new Posicion(11, 11);

		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoDeDerecha = mock(Soldado.class);
		Unidad soldadoDeIzquierda = mock(Soldado.class);

		nuevoTablero.colocarUnidad(soldadoDeDerecha, posicionCentro.derecha());
		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
		nuevoTablero.colocarUnidad(soldadoDeIzquierda, posicionCentro.izquierda());

		nuevoTablero.moverUnidad(posicionCentro, posicionCentro.derecha());

		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.derecha()));
		Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionCentro.derecha().derecha()));
		Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionCentro.izquierda().derecha()));

		nuevoTablero.moverUnidad(posicionCentro.derecha(), posicionCentro);


		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro));
		Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionCentro.derecha()));
		Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionCentro.izquierda()));

	}

	public void test10TableroMoverBatallonVerticalSeMueveVerticalmente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, MovimientoInvalido {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionCentro = new Posicion(12, 11);

		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoDeArriba = mock(Soldado.class);
		Unidad soldadoDeAbajo = mock(Soldado.class);

		nuevoTablero.colocarUnidad(soldadoDeArriba, posicionCentro.arriba());
		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
		nuevoTablero.colocarUnidad(soldadoDeAbajo, posicionCentro.abajo());

		nuevoTablero.moverUnidad(posicionCentro, posicionCentro.arriba());

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba().arriba()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo().arriba()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.arriba()));

		nuevoTablero.moverUnidad(posicionCentro.arriba(), posicionCentro);

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro));
	}

	public void test11TableroMoverBatallonVerticalSeMueveHorizontalmente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, MovimientoInvalido {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionCentro = new Posicion(12, 11);

		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoDeArriba = mock(Soldado.class);
		Unidad soldadoDeAbajo = mock(Soldado.class);

		nuevoTablero.colocarUnidad(soldadoDeArriba, posicionCentro.arriba());
		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
		nuevoTablero.colocarUnidad(soldadoDeAbajo, posicionCentro.abajo());

		nuevoTablero.moverUnidad(posicionCentro, posicionCentro.derecha());

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba().derecha()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo().derecha()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.derecha()));

		nuevoTablero.moverUnidad(posicionCentro.derecha(), posicionCentro);

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro));

	}

	public void test12TableroUnidadesEnElBordeSePuedenMover() throws TableroSectorInvalido, CeldaNoTieneUnidad, CeldaYaTieneUnidad, MovimientoInvalido, NoSeEncontroLaCelda {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionDeUnidad = new Posicion(20, 20);
		Unidad unSoldado = mock(Soldado.class);

		try {
			nuevoTablero.colocarUnidad(unSoldado, posicionDeUnidad);
			nuevoTablero.moverUnidad(posicionDeUnidad, posicionDeUnidad.arriba());
		} catch (CeldaNoEstaEnElTablero celdaNoEstaEnElTablero) {
			fail("No se deberia tirar la celda no esta en el tablero.");
		}

	}

	public void test13TableroObstaculoDetieneUnSoldadoDelBatallon() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, CeldaNoTieneUnidad, CeldaYaTieneUnidad, MovimientoInvalido, NoSeEncontroLaCelda {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionCentro = new Posicion(12, 11);

		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoDeArriba = mock(Soldado.class);
		Unidad soldadoDeAbajo = mock(Soldado.class);
		Unidad soldadoMolesto = mock(Soldado.class);

		nuevoTablero.colocarUnidad(soldadoDeArriba, posicionCentro.arriba());
		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
		nuevoTablero.colocarUnidad(soldadoDeAbajo, posicionCentro.abajo());
		nuevoTablero.colocarUnidad(soldadoMolesto, posicionCentro.derecha());

		nuevoTablero.moverUnidad(posicionCentro, posicionCentro.derecha());

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba().derecha()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo().derecha()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro));

	}

	public void test14TableroBatallonConUnSoldadoDeMasSoloMueveTresSoldados() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, CeldaNoTieneUnidad, CeldaYaTieneUnidad, MovimientoInvalido, NoSeEncontroLaCelda {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionDelCentro = new Posicion(20, 10);

		Unidad soldadoDeDerecha = mock(Soldado.class);
		Unidad soldadoDeIzquierda = mock(Soldado.class);
		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoQueSobra = mock(Soldado.class);

		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionDelCentro);
		nuevoTablero.colocarUnidad(soldadoDeDerecha, posicionDelCentro.derecha());
		nuevoTablero.colocarUnidad(soldadoDeIzquierda, posicionDelCentro.izquierda());
		nuevoTablero.colocarUnidad(soldadoQueSobra, posicionDelCentro.derecha().derecha());

		nuevoTablero.moverUnidad(posicionDelCentro, posicionDelCentro.arriba());

		Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionDelCentro.derecha().arriba()));
		Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionDelCentro.izquierda().arriba()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionDelCentro.arriba()));
		Assert.assertEquals(soldadoQueSobra, nuevoTablero.verUnidad(posicionDelCentro.derecha().derecha()));

	}

	public void test15TableroObstaculoDetieneUnSoldadoDelBatallonYElBatallonQuedaSeparado() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, CeldaNoTieneUnidad, CeldaYaTieneUnidad, MovimientoInvalido, NoSeEncontroLaCelda {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion posicionCentro = new Posicion(12, 11);

		Unidad soldadoDelCentro = mock(Soldado.class);
		Unidad soldadoDeArriba = mock(Soldado.class);
		Unidad soldadoDeAbajo = mock(Soldado.class);
		Unidad jineteMolesto = mock(Jinete.class);

		nuevoTablero.colocarUnidad(soldadoDeArriba, posicionCentro.arriba());
		nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
		nuevoTablero.colocarUnidad(soldadoDeAbajo, posicionCentro.abajo());
		nuevoTablero.colocarUnidad(jineteMolesto, posicionCentro.abajo().derecha());

		nuevoTablero.moverUnidad(posicionCentro, posicionCentro.derecha());

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba().derecha()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.derecha()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo()));

		nuevoTablero.moverUnidad(posicionCentro.derecha(), posicionCentro.derecha().derecha());

		Assert.assertEquals(soldadoDeArriba, nuevoTablero.verUnidad(posicionCentro.arriba().derecha()));
		Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.derecha().derecha()));
		Assert.assertEquals(soldadoDeAbajo, nuevoTablero.verUnidad(posicionCentro.abajo()));
		Assert.assertEquals(jineteMolesto, nuevoTablero.verUnidad(posicionCentro.abajo().derecha()));

	}

	public void test16TableroTrataDeMoverUnidadMasLejosQueUnCasilleroYLanzaExcepcion() throws NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, TableroSectorInvalido, CeldaNoEstaEnElTablero {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unSoldado = mock(Soldado.class);
		Posicion unaPosicion = new Posicion(20, 20);

		nuevoTablero.colocarUnidad(unSoldado, unaPosicion);


		try {
			nuevoTablero.moverUnidad(unaPosicion, unaPosicion.arriba().arriba());
			fail("No se lanzo la excepcion de movimiento invalido.");
		} catch (MovimientoInvalido movimientoInvalido) {
		}

	}

	public void test17TableroTrataDeMoverCatapultaYLanzaExcepcion() throws NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, TableroSectorInvalido, CeldaNoEstaEnElTablero {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unaCatapulta = mock(Catapulta.class);
		Posicion unaPosicion = new Posicion(20, 20);

		nuevoTablero.colocarUnidad(unaCatapulta,unaPosicion);

		try {
			nuevoTablero.moverUnidad(unaPosicion, unaPosicion.arriba().arriba());
			fail("No se lanzo la excepcion de movimiento invalido.");
		} catch (MovimientoInvalido movimientoInvalido) {
		}

	}

	public void test18TableroSeIntentaColocarUnaUnidadFueraDelTableroYSeLanzaLaExcepcion() throws TableroSectorInvalido, CeldaYaTieneUnidad {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unaCatapulta = mock(Catapulta.class);
		Posicion unaPosicion = new Posicion(21, 21);

		try {
			nuevoTablero.colocarUnidad(unaCatapulta,unaPosicion);
			fail("No se lanzo la excepcion de CeldaNoEstaEnElTablero");
		} catch (CeldaNoEstaEnElTablero celdaNoEstaEnElTablero) {
		}

	}

	public void test19TableroSeIntentaColocarUnaUnidadSobreOtraYSeLanzaLaExcepcion() throws TableroSectorInvalido, CeldaNoEstaEnElTablero {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unaCatapulta = mock(Catapulta.class);
		Unidad catapultaInvasoraDeEspacioPersonal = mock(Catapulta.class);
		Posicion unaPosicion = new Posicion(20, 20);

		try {
			nuevoTablero.colocarUnidad(unaCatapulta,unaPosicion);
			nuevoTablero.colocarUnidad(catapultaInvasoraDeEspacioPersonal,unaPosicion);
			fail("No se lanzo la excepcion de CeldaYaTieneUnidad");
		} catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
		}


	}

	public void test20TableroSeCambiaDeSectorDosVecesYNoSeLanzaLaExcepcionDeSectorInvalido() throws CeldaYaTieneUnidad, CeldaNoEstaEnElTablero {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Unidad unaCatapulta = mock(Catapulta.class);
		Posicion unaPosicion = new Posicion(20, 20);

		nuevoTablero.cambiarSector();
		nuevoTablero.cambiarSector();

		try {
			nuevoTablero.colocarUnidad(unaCatapulta,unaPosicion);
		} catch (TableroSectorInvalido tableroSectorInvalido) {
			fail("Se Lanzo la excepcion de sector invalido");
		}
	}

	public void test21TableroSeTrataDeVerUnaUnidadFueraDelTableroYLanzaLaExcepcion() throws CeldaNoTieneUnidad {

		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
		Posicion unaPosicion = new Posicion(21, 21);

		try {
			nuevoTablero.verUnidad(unaPosicion);
			fail("No se lanzo la excepcion de celdaFueraDelTablero");
		} catch (CeldaNoEstaEnElTablero celdaNoEstaEnElTablero) {
		}
	}

	public void test22TableroSeAnalizaLaAdyacenciaCorrectaDeVariasCeldas() throws NoSeEncontroLaCelda {
		Equipo equipoDeJorge = mock(Equipo.class);
		Equipo equipoDeRaul = mock(Equipo.class);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);

		Posicion posicionCeldaCentral = new Posicion(4 , 5);
		Celda celdaCentral = nuevoTablero.buscarCeldaConPosicion(posicionCeldaCentral);

		assertTrue(celdaCentral.verCeldasAdyacentes().contains(nuevoTablero.buscarCeldaConPosicion(posicionCeldaCentral.arriba())));
		assertTrue(celdaCentral.verCeldasAdyacentes().contains(nuevoTablero.buscarCeldaConPosicion(posicionCeldaCentral.abajo())));
		assertTrue(celdaCentral.verCeldasAdyacentes().contains(nuevoTablero.buscarCeldaConPosicion(posicionCeldaCentral.derecha())));
		assertTrue(celdaCentral.verCeldasAdyacentes().contains(nuevoTablero.buscarCeldaConPosicion(posicionCeldaCentral.izquierda())));
	}
}