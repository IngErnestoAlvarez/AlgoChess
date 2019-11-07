package tablerotest;

import ErroresYExcepciones.CeldaNoEstaEnMiSector;
import ErroresYExcepciones.CeldaNoTieneUnidad;
import ErroresYExcepciones.CeldaYaTieneUnidad;
import unidad.Unidad;
import unidad.Soldado;
import celda.Celda;
import junit.framework.Assert;
import junit.framework.TestCase;
import tablero.Sector;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SectorTest extends TestCase {

    public void test00SectorSeCreaElSector(){
        Sector miSector = new Sector();
        Assert.assertNotNull(miSector);
    }

    public void test01SectorSePuedeColocarUnaUnidadEnElSector() throws CeldaYaTieneUnidad, CeldaNoTieneUnidad {
        Sector miSector = new Sector();

        Celda unaCelda = mock(Celda.class);
        Unidad unSoldado = mock(Soldado.class);

        when(unaCelda.verUnidad()).thenReturn(unSoldado);

        miSector.agregar(unaCelda);

        try {
            miSector.colocarUnidad(unaCelda, unSoldado);
        } catch (CeldaNoEstaEnMiSector celdaNoEstaEnMiSector) {
            fail("Lanzo excepcion de Celda no esta en el sector cuando esta fue agregada.");
        }

        Assert.assertEquals(unaCelda.verUnidad(),unSoldado);

    }

    public void test02SectorNoSePuedeColocarUnaUnidadEnUnaCeldaQueNoPertenece() throws CeldaYaTieneUnidad {
        Sector miSector = new Sector();

        Celda unaCelda = mock(Celda.class);
        Unidad unSoldado = mock(Soldado.class);

        try{
            miSector.colocarUnidad(unaCelda, unSoldado);
            fail("No lanzó la excepción que no contiene la celda");
        }  catch (CeldaNoEstaEnMiSector celdaNoEstaEnMiSector) {
        }
    }



}
