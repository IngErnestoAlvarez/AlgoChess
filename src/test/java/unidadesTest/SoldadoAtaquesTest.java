package unidadesTest;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import junit.framework.TestCase;
import modelo.unidad.*;

public class SoldadoAtaquesTest extends TestCase {

    public void test00SoldadoNoPuedeAtacarAUnidadLejana() throws RangoMuyLejano, RangoMuyCercano {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        try {
            soldado.interactuar(jinete, 4,1);
        }catch(RangoMuyLejano e){}

        assertEquals(100.0, jinete.getVida());

    }

    public void test01SoldadoAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.interactuar(jinete, 1,1);

        assertEquals(90.0, jinete.getVida());

    }


    public void test03SoldadoAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        soldado.interactuar(catapulta, 1,1);

        assertEquals(40.0, catapulta.getVida());

    }

    public void test04SoldadoAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();

        soldado.interactuar(curandero, 1,1);

        assertEquals(65.0, curandero.getVida());

    }

    public void test05SoldadoAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.interactuar(soldado2, 1,1);

        assertEquals(90.0, soldado2.getVida());

    }

}
