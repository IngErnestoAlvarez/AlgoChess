
package unidadesTest;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import junit.framework.TestCase;
import modelo.unidad.*;

public class CatapultaAtaquesTest extends TestCase {

    public void test01CatapultaNoPuedeAtacarAUnidadCercana() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete(new Celda(), new Equipo());

        try {
            catapulta.interactuar(jinete, 1);
        }catch(RangoMuyCercano e){}

        assertEquals(100, jinete.getVida());
    }

    public void test02CatapultaAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete(new Celda(), new Equipo());

        catapulta.interactuar(jinete, 7);

        assertEquals(80, jinete.getVida());
    }

    public void test03CatapultaAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta(new Celda(), new Equipo());

        catapulta1.interactuar(catapulta2, 7);

        assertEquals(30, catapulta2.getVida());

    }

    public void test04CatapultaAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado(new Celda(), new Equipo());

        catapulta.interactuar(soldado, 7);

        assertEquals(80, soldado.getVida());

    }

    public void test05CatapultaAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero(new Celda(), new Equipo());

        catapulta.interactuar(curandero, 7);

        assertEquals(55, curandero.getVida());

    }

}
