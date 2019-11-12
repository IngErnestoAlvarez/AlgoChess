
package unidadesTest;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import equipo.Equipo;
import junit.framework.TestCase;
import unidad.*;

import static org.mockito.Mockito.mock;

public class JineteAtaquesTest extends TestCase {

    public void test01JineteAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        jinete1.interactuar(jinete2, 1);

        assertEquals(95, jinete2.getVida());

    }


    public void test02JineteAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {


        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        jinete1.cambiarAtaque();

        jinete1.interactuar(jinete2, 3);

        assertEquals(85, jinete2.getVida());
    }

    public void test03JineteAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();

        jinete.interactuar(catapulta, 1);

        assertEquals(45, catapulta.getVida());

    }

    public void test04JineteAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();

        jinete.cambiarAtaque();

        jinete.interactuar(catapulta, 3);

        assertEquals(35, catapulta.getVida());

    }

    public void test05JineteAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.interactuar(curandero, 1);

        assertEquals(70, curandero.getVida());

    }

    public void test06JineteAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.cambiarAtaque();

        jinete.interactuar(curandero, 3);

        assertEquals(60, curandero.getVida());

    }

    public void test07JineteAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        jinete.interactuar(soldado, 1);

        assertEquals(95, soldado.getVida());

    }

    public void test08JineteAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {

        Jinete jinete = new Jinete();
        Soldado soldado = new Soldado();

        jinete.cambiarAtaque();

        jinete.interactuar(soldado, 5);

        assertEquals(85, soldado.getVida());

    }

    public void test09JineteTieneUnidadEnemigaCercaYAtacaConLaEspada(){
        Jinete jinete = new Jinete();
        Unidad soldadoEnemigo = new Soldado();

        Equipo equipoAliado = mock(Equipo.class);
        jinete.setEquipo(equipoAliado);

        Equipo equipoEnemigo = mock(Equipo.class);
        soldadoEnemigo.setEquipo(equipoEnemigo);

        try {
            jinete.interactuar(soldadoEnemigo, 1);
        } catch (RangoMuyLejano rangoMuyLejano) {
            fail("Tendria que no ser mayor al rango");
        } catch (RangoMuyCercano rangoMuyCercano) {
            fail("Tendria que no ser menor al rango");
        }

        assertEquals(95, soldadoEnemigo.getVida());
    }

    public void test10JineteTieneUnidadEnemigaLejosYAtacaConArcoYFlecha(){
        Jinete jinete = new Jinete();
        Unidad soldadoEnemigo = new Soldado();

        Equipo equipoAliado = mock(Equipo.class);
        jinete.setEquipo(equipoAliado);

        Equipo equipoEnemigo = mock(Equipo.class);
        soldadoEnemigo.setEquipo(equipoEnemigo);

        jinete.cambiarAtaque();
        try {
            jinete.interactuar(soldadoEnemigo, 4);
        } catch (RangoMuyLejano rangoMuyLejano) {
            fail("Tendria que no ser mayor al rango");
        } catch (RangoMuyCercano rangoMuyCercano) {
            fail("Tendria que no ser menor al rango");
        }

        assertEquals(85, soldadoEnemigo.getVida());
    }

    public void test11JineteTieneUnidadEnemigaDemasiadoLejosYlanzaExcepcion(){
        Jinete jinete = new Jinete();
        Unidad soldadoEnemigo = new Soldado();

        Equipo equipoAliado = mock(Equipo.class);
        jinete.setEquipo(equipoAliado);

        Equipo equipoEnemigo = mock(Equipo.class);
        soldadoEnemigo.setEquipo(equipoEnemigo);

        jinete.cambiarAtaque();
        try {
            jinete.interactuar(soldadoEnemigo, 10);
            fail("Tendria que ser mayor el rango");
        } catch (RangoMuyLejano rangoMuyLejano) {
        } catch (RangoMuyCercano rangoMuyCercano) {
            fail("Tendria que no ser menor al rango");
        }
    }
}
