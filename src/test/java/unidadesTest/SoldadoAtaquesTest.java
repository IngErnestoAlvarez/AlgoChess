package unidadesTest;

import ErroresYExcepciones.SoldadoNoPuedeAtacarDeLejos;
import junit.framework.TestCase;
import unidades.*;

public class SoldadoAtaquesTest extends TestCase {

    public void testsoldadoAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.ataqueCercano(jinete);

        assertEquals(90, jinete.getVida());

    }


    public void testsoldadoAtacaAUnidadLejanaYNoLeHaceDanio(){


        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        try{
            soldado.ataqueLejano(jinete);
        }
        catch(SoldadoNoPuedeAtacarDeLejos e){}

        assertEquals(100, jinete.getVida());
    }

    public void testsoldadoAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        soldado.ataqueCercano(catapulta);

        assertEquals(40, catapulta.getVida());

    }

    public void testsoldadoAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();

        soldado.ataqueCercano(curandero);

        assertEquals(65, curandero.getVida());

    }

    public void testsoldadoAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.ataqueCercano(soldado2);

        assertEquals(90, soldado2.getVida());

    }

}
