
package unidadesTest;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import junit.framework.TestCase;
import modelo.unidad.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JineteAtaquesTest extends TestCase {

    public void test01JineteAtacaAJineteCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete1 = mock(Celda.class);
        Celda celdaJinete2 = mock(Celda.class);

        Jinete jinete1 = new Jinete(celdaJinete1, equipoAliado);
        Jinete jinete2 = new Jinete(celdaJinete2, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();
        listaDeUnidadesCercanas.add(jinete2);

        when(celdaJinete1.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);


        jinete1.interactuar(jinete2, 1, 1);

        assertEquals(95.0, jinete2.getVida());

    }


    public void test02JineteAtacaAJineteLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete1 = mock(Celda.class);
        Celda celdaJinete2 = mock(Celda.class);

        Jinete jinete1 = new Jinete(celdaJinete1, equipoAliado);
        Jinete jinete2 = new Jinete(celdaJinete2, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();

        when(celdaJinete1.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        jinete1.interactuar(jinete2, 3,1);

        assertEquals(85.0, jinete2.getVida());
    }

    public void test03JineteAtacaACatapultaCercanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaCatapulta = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Catapulta catapulta = new Catapulta(celdaCatapulta, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();

        listaDeUnidadesCercanas.add(catapulta);

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        jinete.interactuar(catapulta, 1,1);

        assertEquals(45.0, catapulta.getVida());

    }

    public void test04JineteAtacaACatapultaLejanaYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaCatapulta = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Catapulta catapulta = new Catapulta(celdaCatapulta, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();


        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        jinete.interactuar(catapulta, 4,1);

        assertEquals(35.0, catapulta.getVida());
    }

    public void test05JineteAtacaACuranderoCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaCurandero = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Curandero curandero = new Curandero(celdaCurandero, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();
        listaDeUnidadesCercanas.add(curandero);

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        jinete.interactuar(curandero, 1,1);

        assertEquals(70.0, curandero.getVida());

    }

    public void test06JineteAtacaACuranderoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaCurandero = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Curandero curandero = new Curandero(celdaCurandero, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        jinete.interactuar(curandero, 3,1);

        assertEquals(60.0, curandero.getVida());

    }

    public void test07JineteAtacaASoldadoCercanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaSoldado = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Soldado soldado = new Soldado(celdaSoldado, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();
        listaDeUnidadesCercanas.add(soldado);

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        jinete.interactuar(soldado, 1,1);

        assertEquals(95.0, soldado.getVida());

    }

    public void test08JineteAtacaASoldadoLejanoYLeQuitaLaVidaCorrecta() throws RangoMuyLejano, RangoMuyCercano {
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaSoldado = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Soldado soldado = new Soldado(celdaSoldado, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);


        jinete.interactuar(soldado, 5,1);

        assertEquals(85.0, soldado.getVida());

    }


    public void test09JineteTieneUnidadEnemigaDemasiadoLejosYlanzaExcepcion(){
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaSoldado = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Unidad soldadoEnemigo = new Soldado(celdaSoldado, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        try {
            jinete.interactuar(soldadoEnemigo, 10,1);
            fail("Tendria que ser mayor el rango");
        } catch (RangoMuyLejano ignore) {
        } catch (RangoMuyCercano rangoMuyCercano) {
            fail("Tendria que no ser menor al rango");
        }
    }

    public void test10JineteTieneUnidadEnemigaCercaYNoPuedeAtacarLejos(){
        Equipo equipoAliado = mock(Equipo.class);
        Equipo equipoEnemigo = mock(Equipo.class);
        Celda celdaJinete = mock(Celda.class);
        Celda celdaSoldado = mock(Celda.class);

        Jinete jinete = new Jinete(celdaJinete, equipoAliado);
        Unidad soldadoEnemigoCercano = new Soldado(celdaSoldado, equipoEnemigo);
        Unidad soldadoEnemigoLejano = new Soldado(celdaSoldado, equipoEnemigo);

        List<Unidad> listaDeUnidadesCercanas = new ArrayList<>();

        listaDeUnidadesCercanas.add(soldadoEnemigoCercano);

        when(celdaJinete.verUnidadesAdyacentes()).thenReturn(listaDeUnidadesCercanas);

        try {
            jinete.interactuar(soldadoEnemigoLejano, 4,1);
            fail("Tendria que ser mayor el rango");
        } catch (RangoMuyLejano ignore) {
        } catch (RangoMuyCercano rangoMuyCercano) {
            fail("Tendria que no ser menor al rango");
        }
    }
}
