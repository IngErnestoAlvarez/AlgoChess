package unidadesTest;

import ErroresYExcepciones.*;
import celda.Celda;
import celda.Posicion;
import equipo.Equipo;
import junit.framework.Assert;
import junit.framework.TestCase;
import tablero.Tablero;
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
        Celda unaCelda = new Celda(posicionCentro);
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

        nuevoTablero.colocarUnidad(unSoldado, posicionCentro.derecha());
        nuevoTablero.colocarUnidad(dosSoldado, posicionCentro);

        try {
            nuevoTablero.moverBatallon(posicionCentro,posicionCentro.derecha());
            fail("No se lanzo la excepcion de batallon invalido");
        } catch (NoEsBatallon noEsBatallon) {
        }
    }
}
