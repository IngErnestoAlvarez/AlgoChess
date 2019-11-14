
package unidadesTest;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import junit.framework.TestCase;
import unidad.*;

public class CatapultaAtaquesTest extends TestCase {

    public void test01CatapultaNoPuedeAtacarAUnidadCercana() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        try {
            catapulta.interactuar(jinete, 1);
        }catch(RangoMuyCercano e){}

        assertEquals(100, jinete.getVida());
    }

    public void test02CatapultaAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        catapulta.interactuar(jinete, 7);

        assertEquals(80, jinete.getVida());
    }

    public void test03CatapultaAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();

        catapulta1.interactuar(catapulta2, 7);

        assertEquals(30, catapulta2.getVida());

    }

    public void test04CatapultaAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        catapulta.interactuar(soldado, 7);

        assertEquals(80, soldado.getVida());

    }

    public void test05CatapultaAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();

        catapulta.interactuar(curandero, 7);

        assertEquals(55, curandero.getVida());

    }

}
