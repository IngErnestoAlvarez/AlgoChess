package tablerotest;

import ErroresYExcepciones.TableroSectorInvalido;
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

	public void test00SeCreaTableroYLaReferenciaNoEsVacia() {
		Equipo equipoDeEugenio = new Equipo("Eugenio", 20);
		Equipo equipoDePepe = new Equipo("Pepe", 20);
		Tablero nuevoTablero = new Tablero(20, 20, equipoDePepe, equipoDeEugenio);
		Assert.assertNotNull(nuevoTablero);
	}

	public void test01SoloSePuedeColocarUnaUnidadEnElTableroAliado(){
		Equipo equipoDeJorge = new Equipo("Jorge", 20); //nombre,puntos;
		Equipo equipoDeRaul = new Equipo("Raul", 20);
		Tablero nuevoTablero = new Tablero( 20,20, equipoDeJorge, equipoDeRaul );
		Unidad unSoldado = new Soldado();
		Celda unaCelda = new Celda(0,0);
		try{
			nuevoTablero.colocarUnidad( unSoldado, unaCelda ); // empieza poniendo el equipo de abajo.
			fail("No se lanzo la excepcion de sector invalido");
		}catch (TableroSectorInvalido excepcion){}
	}

}
