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

public class SectorTest extends TestCase {

    public void test00SectorSeCreaElSector(){
        Sector miSector = new Sector();
        Assert.assertNotNull(miSector);
    }

    public void test01SectorSePuedeColocarUnaUnidadEnElSector() throws CeldaYaTieneUnidad, CeldaNoTieneUnidad {
        Sector miSector = new Sector();
        Celda unaCelda = new Celda();
        Unidad unSoldado = new Soldado();

        miSector.agregar(unaCelda);

        try {
            miSector.colocarUnidad(unaCelda, unSoldado);
        } catch (CeldaNoEstaEnMiSector celdaNoEstaEnMiSector) {
            celdaNoEstaEnMiSector.printStackTrace();
            fail("Lanzo excepcion de Celda no esta en el sector cuando esta fue agregada.");
        }

        Assert.assertEquals(unaCelda.verUnidad(),unSoldado);

    }



}
