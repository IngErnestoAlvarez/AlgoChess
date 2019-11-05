package unidadesTest;

import junit.framework.TestCase;
import unidad.*;

public class SoldadoAtaquesTest extends TestCase {

    public void test01SoldadoAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.interactuar(jinete);

        assertEquals(90, jinete.getVida());

    }


    public void test03SoldadoAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        soldado.interactuar(catapulta);

        assertEquals(40, catapulta.getVida());

    }

    public void test04SoldadoAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();

        soldado.interactuar(curandero);

        assertEquals(65, curandero.getVida());

    }

    public void test05SoldadoAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.interactuar(soldado2);

        assertEquals(90, soldado2.getVida());

    }

}
