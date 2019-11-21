package unidadesTest;

import ErroresYExcepciones.*;
import celda.Celda;
import celda.Posicion;
import equipo.Equipo;
import junit.framework.Assert;
import junit.framework.TestCase;
import tablero.Tablero;
import tablero.movimientos.Movimiento;
import unidad.Soldado;
import unidad.Unidad;
import unidad.batallon.Batallon;

import static org.mockito.Mockito.mock;

public class BatallonTest extends TestCase {

    public void test00BatallonSeCreaElBatallonYLaReferenciaNoEsVacia() throws NoSeEncontroLaCelda, CeldaNoTieneUnidad, NoEsBatallon, CeldaYaTieneUnidad, TableroSectorInvalido, CeldaNoEstaEnElTablero {
        Equipo elEje = mock(Equipo.class);
        Equipo losAliados = mock(Equipo.class);
        Tablero nuevoTablero = new Tablero(20, 20, elEje, losAliados);
        Posicion posicionCentro = new Posicion(15, 15);
        Celda unaCelda = nuevoTablero.buscarCeldaConPosicion(posicionCentro);
        Unidad unSoldado = mock(Soldado.class);
        Unidad dosSoldado = mock(Soldado.class);
        Unidad tresSoldado = mock(Soldado.class);

        nuevoTablero.colocarUnidad(unSoldado, posicionCentro.derecha());
        nuevoTablero.colocarUnidad(dosSoldado, posicionCentro);
        nuevoTablero.colocarUnidad(tresSoldado, posicionCentro.izquierda());

        Batallon unBatallon = new Batallon(unaCelda,nuevoTablero);

        Assert.assertNotNull(unBatallon);
    }

    public void test01BatallonSeIntentaCrearUnBatallonInvalidoYLanzaLaExcepcion() throws CeldaYaTieneUnidad, TableroSectorInvalido, CeldaNoEstaEnElTablero, CeldaNoTieneUnidad, NoSeEncontroLaCelda, MovimientoInvalido {
        Equipo elEje = mock(Equipo.class);
        Equipo losAliados = mock(Equipo.class);
        Tablero nuevoTablero = new Tablero(20, 20, elEje, losAliados);
        Posicion posicionCentro = new Posicion(15, 15);
        Unidad unSoldado = mock(Soldado.class);
        Unidad dosSoldado = mock(Soldado.class);
        Celda unaCelda = nuevoTablero.buscarCeldaConPosicion(posicionCentro);

        nuevoTablero.colocarUnidad(unSoldado, posicionCentro.derecha());
        nuevoTablero.colocarUnidad(dosSoldado, posicionCentro);

        try {
            Batallon unBatallon = new Batallon(unaCelda, nuevoTablero);
            fail("No se lanzo la excepcion de batallon invalido");
        } catch (NoEsBatallon noEsBatallon) {
        }
    }

    public void test02BatallonBatallonHorizontalSeMueveVerticalmente() throws TableroSectorInvalido, CeldaNoEstaEnElTablero, NoSeEncontroLaCelda, CeldaYaTieneUnidad, CeldaNoTieneUnidad, MovimientoInvalido, NoEsBatallon {

        Equipo equipoDeJorge = mock(Equipo.class);
        Equipo equipoDeRaul = mock(Equipo.class);
        Tablero nuevoTablero = new Tablero(20, 20, equipoDeJorge, equipoDeRaul);
        Posicion posicionCentro = new Posicion(11, 11);
        Celda unaCelda = nuevoTablero.buscarCeldaConPosicion(posicionCentro);

        Unidad soldadoDelCentro = mock(Soldado.class);
        Unidad soldadoDeDerecha = mock(Soldado.class);
        Unidad soldadoDeIzquierda = mock(Soldado.class);

        nuevoTablero.colocarUnidad(soldadoDeDerecha, posicionCentro.derecha());
        nuevoTablero.colocarUnidad(soldadoDelCentro, posicionCentro);
        nuevoTablero.colocarUnidad(soldadoDeIzquierda, posicionCentro.izquierda());

        Batallon unBatallon = new Batallon(unaCelda,nuevoTablero);
        Movimiento unMovimiento = new Movimiento (posicionCentro,posicionCentro.arriba());

        unBatallon.moverBatallon(unMovimiento);

        Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionCentro.derecha().arriba()));
        Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionCentro.izquierda().arriba()));
        Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro.arriba()));

        Celda otraCelda = nuevoTablero.buscarCeldaConPosicion(posicionCentro.arriba());
        Batallon otroBatallon = new Batallon(otraCelda,nuevoTablero);
        Movimiento otroMovimiento = new Movimiento (posicionCentro.arriba(),posicionCentro);

        otroBatallon.moverBatallon(otroMovimiento);

        Assert.assertEquals(soldadoDelCentro, nuevoTablero.verUnidad(posicionCentro));
        Assert.assertEquals(soldadoDeDerecha, nuevoTablero.verUnidad(posicionCentro.derecha()));
        Assert.assertEquals(soldadoDeIzquierda, nuevoTablero.verUnidad(posicionCentro.izquierda()));

    }

}
