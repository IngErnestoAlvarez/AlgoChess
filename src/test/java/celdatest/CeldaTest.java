package celdatest;

import ErroresYExcepciones.CeldaNoTieneUnidad;
import ErroresYExcepciones.CeldaYaTieneUnidad;
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
        try {
            Celda celda = new Celda();

            Unidad unidad = new UnidadMock();

            celda.colocarUnidad(unidad);

            celda.quitarUnidad();

            assertFalse(celda.estaOcupada());
            assertTrue(celda.estaVacia());
        }
        catch (CeldaNoTieneUnidad e){
            fail("Lanzada la excepcion: CeldaNoTieneUnidad");
        }
    }

    public void testCeldaTiraExcepcionSiQuitoUnidadCuandoNoTiene(){
        Celda celda = new Celda();
        try{
            celda.quitarUnidad();
            fail("No se lanzo la excepcion");
        }catch (CeldaNoTieneUnidad e){}

    }

    public void testCeldaOcupadaTiraExcepcionSiIntentoColocarOtraUnaUnidad(){
        Celda celda = new Celda();

        Unidad unidad1 = new UnidadMock();

        celda.colocarUnidad(unidad1);

        Unidad unidad2 = new UnidadMock();

        try{
            celda.colocarUnidad(unidad2);
            fail("Se colocaron 2 unidades en una celda. No tiro excepcion");
        }
        catch (CeldaYaTieneUnidad e){
        }
    }
    private class UnidadMock extends Unidad{
    }
}