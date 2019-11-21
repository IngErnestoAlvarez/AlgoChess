package tablerotest;

import modelo.ErroresYExcepciones.CeldaNoEstaEnMiSector;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.CeldaYaTieneUnidad;
import modelo.unidad.Unidad;
import modelo.unidad.Soldado;
import modelo.celda.Celda;
import junit.framework.Assert;
import junit.framework.TestCase;
import modelo.tablero.Sector;

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
            fail("No lanzó la excepción que no contiene la modelo.celda");
        }  catch (CeldaNoEstaEnMiSector celdaNoEstaEnMiSector) {
        }
    }



}
