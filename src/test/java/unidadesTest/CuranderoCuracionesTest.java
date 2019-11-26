
package unidadesTest;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import junit.framework.TestCase;

import modelo.unidad.*;

public class CuranderoCuracionesTest extends TestCase {

    public void test01CuranderoNoPuedeCurarUnaCatapulta() throws RangoMuyLejano, RangoMuyCercano {

        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        soldado.interactuar(catapulta, 1,1);

        curandero.interactuar(catapulta, 1,1);

        assertEquals(40.0, catapulta.getVida());
    }

    public void test02CuranderoNoPuedeCurarUnaUnidadLejana() throws RangoMuyLejano, RangoMuyCercano {

        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        soldado.interactuar(jinete, 1,1);

        try {
            curandero.interactuar(jinete, 5,1);
        }catch(RangoMuyLejano ignore){}

        assertEquals(90.0, jinete.getVida());
    }

    public void test03CuranderoCuraSoldadoLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Curandero curandero = new Curandero();
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.interactuar(soldado2, 1,1);

        curandero.interactuar(soldado2, 1,1);

        assertEquals(105.0, soldado2.getVida());

    }

    public void test04CuranderoCuraJineteLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Curandero curandero = new Curandero();
        Jinete jinete= new Jinete();
        Soldado soldado = new Soldado();

        soldado.interactuar(jinete, 1,1);

        curandero.interactuar(jinete, 1,1);

        assertEquals(105.0, jinete.getVida());

    }

    public void test05CuranderoCuraCuranderoLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Curandero curandero1 = new Curandero();
        Soldado soldado = new Soldado();
        Curandero curandero2 = new Curandero();

        soldado.interactuar(curandero2, 1,1);

        curandero1.interactuar(curandero2, 1,1);

        assertEquals(80.0, curandero2.getVida());
    }
}

