package unidadesTest;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import junit.framework.TestCase;
import unidad.*;

public class SoldadoAtaquesTest extends TestCase {

    public void test01SoldadoAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.interactuar(jinete, 1);

        assertEquals(90, jinete.getVida());

    }


    public void test03SoldadoAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        soldado.interactuar(catapulta, 1);

        assertEquals(40, catapulta.getVida());

    }

    public void test04SoldadoAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();

        soldado.interactuar(curandero, 1);

        assertEquals(65, curandero.getVida());

    }

    public void test05SoldadoAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.interactuar(soldado2, 1);

        assertEquals(90, soldado2.getVida());

    }

}
