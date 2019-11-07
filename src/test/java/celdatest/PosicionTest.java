package celdatest;

import celda.Posicion;
import junit.framework.TestCase;

public class PosicionTest extends TestCase {

    public void test00SeCreaLaPosicionYNoEsNull(){
        Posicion posicion = new Posicion();

        assertNotNull(posicion);
    }
    public void test01LaDistanciaEntre2PosicionesEnElMismoLugarEsCero(){
        Posicion posicion1 = new Posicion(5,2);
        Posicion posicion2 = new Posicion(5,2);

        assertEquals(0, posicion1.medirDistancia(posicion2));
    }

    public void test02LaDistanciaEntreDosPosicionesEsLaMismaSinImportarPorCualEmpiezo(){
        Posicion posicion1 = new Posicion(4, 7);
        Posicion posicion2 = new Posicion(2,1);

        assertEquals(8, posicion1.medirDistancia(posicion2));
        assertEquals(8, posicion2.medirDistancia(posicion1));
    }

    public void test03LaDistanciaDeUnaPosicionConsigoMismoEsCero(){
        Posicion posicion = new Posicion(2,10);

        assertEquals(0, posicion.medirDistancia(posicion));
    }

}
