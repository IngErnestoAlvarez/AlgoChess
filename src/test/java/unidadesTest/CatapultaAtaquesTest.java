
package unidadesTest;

import junit.framework.TestCase;
import unidades.*;

import java.util.ArrayList;

public class CatapultaAtaquesTest extends TestCase {

    public void test02CatapultaAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() {


        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();

        catapulta.interactuar(jinete);

        assertEquals(80, jinete.getVida());
    }

    public void test03CatapultaAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();

        catapulta1.interactuar(catapulta2);

        assertEquals(30, catapulta2.getVida());

    }

    public void test04CatapultaAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        catapulta.interactuar(soldado);

        assertEquals(80, soldado.getVida());

    }

    public void test05CatapultaAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();

        catapulta.interactuar(curandero);

        assertEquals(55, curandero.getVida());

    }

}
