
package unidadesTest;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import junit.framework.TestCase;

import unidad.*;

public class CuranderoCuracionesTest extends TestCase {

    public void test01CuranderoNoPuedeCurarUnaCatapulta() throws RangoMuyLejano, RangoMuyCercano {

        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        soldado.interactuar(catapulta, 1);

        curandero.interactuar(catapulta, 1);

        assertEquals(40, catapulta.getVida());
        }


    public void test03CuranderoCuraSoldadoLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Curandero curandero = new Curandero();
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.interactuar(soldado2, 1);

        curandero.interactuar(soldado2, 1);

        assertEquals(105, soldado2.getVida());

    }

    public void test04CuranderoCuraJineteLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Curandero curandero = new Curandero();
        Jinete jinete= new Jinete();
        Soldado soldado = new Soldado();

        soldado.interactuar(jinete, 1);

        curandero.interactuar(jinete, 1);

        assertEquals(105, jinete.getVida());

    }

    public void test05CuranderoCuraCuranderoLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Curandero curandero1 = new Curandero();
        Soldado soldado = new Soldado();
        Curandero curandero2 = new Curandero();

        soldado.interactuar(curandero2, 1);

        curandero1.interactuar(curandero2, 1);

        assertEquals(80, curandero2.getVida());
    }
}

