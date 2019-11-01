package celdatest;

import Unidad.Unidad;
import celda.Celda;
import junit.framework.TestCase;

public class CeldaTest extends TestCase {


    public void testCeldaEstaVaciaRecienCreada(){
        Celda celda = new Celda();


        assertTrue(celda.estaVacia());
        assertFalse(celda.estaOcupada());
    }

    public void testCeldaEstaOcupadaAlInsertarUnaUnidad(){
        Celda celda = new Celda();

        Unidad unidad = new UnidadMock();

        celda.colocarUnidad(unidad);

        assertTrue(celda.estaOcupada());
        assertFalse(celda.estaVacia());
    }


    public void testCeldaEstaVaciaDespuesDeQuitarLaUnidad(){
        Celda celda = new Celda();

        Unidad unidad = new UnidadMock();

        celda.colocarUnidad(unidad);

        celda.quitarUnidad();

        assertFalse(celda.estaOcupada());
        assertTrue(celda.estaVacia());
    }

    private class UnidadMock extends Unidad{
    }
}