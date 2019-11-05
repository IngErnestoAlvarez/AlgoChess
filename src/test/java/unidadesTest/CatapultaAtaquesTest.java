package unidadesTest;

import ErroresYExcepciones.CatapultaNoPuedeAtacarDeCerca;
import junit.framework.TestCase;
import unidades.*;

public class CatapultaAtaquesTest extends TestCase {

    public void test01CatapultaAtacaAUnidadCercanaYSeLanzaUnaExcepcion() {


        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        try {
            catapulta.ataqueCercano(jinete);
        } catch (CatapultaNoPuedeAtacarDeCerca e) {
        }

        assertEquals(100, jinete.getVida());

    }


    public void test02CatapultaAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() {


        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        catapulta.ataqueLejano(jinete);

        assertEquals(80, jinete.getVida());
    }

    public void test03CatapultaAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();

        catapulta1.ataqueLejano(catapulta2);

        assertEquals(30, catapulta2.getVida());

    }

    public void test04CatapultaAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        catapulta.ataqueLejano(soldado);

        assertEquals(80, soldado.getVida());

    }

    public void test05CatapultaAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();

        catapulta.ataqueLejano(curandero);

        assertEquals(55, curandero.getVida());

    }

}



