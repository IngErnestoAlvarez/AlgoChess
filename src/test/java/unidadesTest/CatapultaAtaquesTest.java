
package unidadesTest;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import junit.framework.TestCase;
import unidad.*;

public class CatapultaAtaquesTest extends TestCase {

    public void test02CatapultaAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {


        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        catapulta.interactuar(jinete, 1);

        assertEquals(80, jinete.getVida());
    }

    public void test03CatapultaAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();

        catapulta1.interactuar(catapulta2, 1);

        assertEquals(30, catapulta2.getVida());

    }

    public void test04CatapultaAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        catapulta.interactuar(soldado, 1);

        assertEquals(80, soldado.getVida());

    }

    public void test05CatapultaAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();

        catapulta.interactuar(curandero, 1);

        assertEquals(55, curandero.getVida());

    }

}
