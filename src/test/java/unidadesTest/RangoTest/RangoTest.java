package unidadesTest.RangoTest;

import junit.framework.TestCase;
import unidad.accion.Rango;

public class RangoTest extends TestCase {

    public void test00RangoContieneUnaCantidadDeNumeros(){
        Rango rango = new Rango(1, 10);

        assertTrue(rango.perteneceAlRango(1));
        assertTrue(rango.perteneceAlRango(2));
        assertTrue(rango.perteneceAlRango(3));
        assertTrue(rango.perteneceAlRango(4));
        assertTrue(rango.perteneceAlRango(5));
        assertTrue(rango.perteneceAlRango(6));
        assertFalse(rango.perteneceAlRango(15));
    }
}
