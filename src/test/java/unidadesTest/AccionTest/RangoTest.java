package unidadesTest.AccionTest;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import junit.framework.TestCase;
import unidad.accion.Rango;

public class RangoTest extends TestCase {

    public void test00RangoContieneUnaCantidadDeNumeros(){
        Rango rango = new Rango(1, 10);
        try{
            assertTrue(rango.perteneceAlRango(1));
            assertTrue(rango.perteneceAlRango(2));
            assertTrue(rango.perteneceAlRango(3));
            assertTrue(rango.perteneceAlRango(4));
            assertTrue(rango.perteneceAlRango(5));
            assertTrue(rango.perteneceAlRango(6));
        }catch (RangoMuyCercano rangoMuyCercano) {
            fail("No tendria que tirar excepcion");
        } catch (RangoMuyLejano rangoMuyLejano) {
            fail("NO tednria que tirar excepcion");
        }
        try{
            rango.perteneceAlRango(15);
            fail("No se lanzo la excepcion");
        } catch (RangoMuyCercano rangoMuyCercano) {
            fail("Tendria que tirar rangoLejano");
        } catch (RangoMuyLejano rangoMuyLejano) {}
    }
}
