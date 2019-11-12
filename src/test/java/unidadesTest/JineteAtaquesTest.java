
package unidadesTest;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import equipo.Equipo;
import junit.framework.TestCase;
import unidad.*;

import static org.mockito.Mockito.mock;

public class JineteAtaquesTest extends TestCase {

    public void test01JineteAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        jinete1.interactuar(jinete2, 1);

        assertEquals(95, jinete2.getVida());

    }


    public void test02JineteAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {


        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        jinete1.cambiarAtaque();

        jinete1.interactuar(jinete2, 1);

        assertEquals(85, jinete2.getVida());
    }

    public void test03JineteAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();

        jinete.interactuar(catapulta, 1);

        assertEquals(45, catapulta.getVida());

    }

    public void test04JineteAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();

        jinete.cambiarAtaque();

        jinete.interactuar(catapulta, 1);

        assertEquals(35, catapulta.getVida());

    }

    public void test05JineteAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.interactuar(curandero, 1);

        assertEquals(70, curandero.getVida());

    }

    public void test06JineteAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.cambiarAtaque();

        jinete.interactuar(curandero, 1);

        assertEquals(60, curandero.getVida());

    }

    public void test07JineteAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        jinete.interactuar(soldado, 1);

        assertEquals(95, soldado.getVida());

    }

    public void test08JineteAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() throws CeldaNoEstaEnRango {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        jinete.cambiarAtaque();

        jinete.interactuar(soldado, 1);

        assertEquals(85, soldado.getVida());

    }

    public void test09JineteTieneUnidadEnemigaCercaYAtacaConLaEspada(){
        Jinete jinete = new Jinete();
        Unidad soldadoEnemigo = new Soldado();

        Equipo equipoAliado = mock(Equipo.class);
        jinete.setEquipo(equipoAliado);

        Equipo equipoEnemigo = mock(Equipo.class);
        soldadoEnemigo.setEquipo(equipoEnemigo);



    }
}
