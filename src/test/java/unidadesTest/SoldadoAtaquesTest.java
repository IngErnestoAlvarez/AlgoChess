package unidadesTest;

import ErroresYExcepciones.SoldadoNoPuedeAtacarDeLejos;
import junit.framework.TestCase;
import unidades.*;

public class SoldadoAtaquesTest extends TestCase {

    public void test01SoldadoAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.ataqueCercano(jinete);

        assertEquals(90, jinete.getVida());

    }


    public void test02SoldadoNoPuedeAtacarDeLejos() throws SoldadoNoPuedeAtacarDeLejos{

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        try{
            soldado.ataqueLejano(jinete);
        }
        catch(SoldadoNoPuedeAtacarDeLejos e){}

        assertEquals(100, jinete.getVida());
    }

    public void test03SoldadoAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        soldado.ataqueCercano(catapulta);

        assertEquals(40, catapulta.getVida());

    }

    public void test04SoldadoAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();

        soldado.ataqueCercano(curandero);

        assertEquals(65, curandero.getVida());

    }

    public void test05SoldadoAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() {

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.ataqueCercano(soldado2);

        assertEquals(90, soldado2.getVida());

    }

}
