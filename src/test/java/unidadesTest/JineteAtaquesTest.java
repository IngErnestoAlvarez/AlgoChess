package unidadesTest;

import junit.framework.TestCase;
import unidades.*;

public class JineteAtaquesTest extends TestCase {

    public void testJineteAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() {

        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        jinete1.ataqueCercano(jinete2);

        assertEquals(95, jinete2.getVida());

    }


    public void testJineteAtacaAJineteLejanoYLeQuitaLaVidaCorrecta(){


        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        jinete1.ataqueLejano(jinete2);

        assertEquals(85, jinete2.getVida());
    }

    public void testJineteAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();

        jinete.ataqueCercano(catapulta);

        assertEquals(45, catapulta.getVida());

    }

    public void testJineteAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();

        jinete.ataqueLejano(catapulta);

        assertEquals(35, catapulta.getVida());

    }

    public void testJineteAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.ataqueCercano(curandero);

        assertEquals(70, curandero.getVida());

    }

    public void testJineteAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.ataqueLejano(curandero);

        assertEquals(60, curandero.getVida());

    }

    public void testJineteAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        jinete.ataqueCercano(soldado);

        assertEquals(95, soldado.getVida());

    }

    public void testJineteAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        jinete.ataqueLejano(soldado);

        assertEquals(85, soldado.getVida());

    }
}

