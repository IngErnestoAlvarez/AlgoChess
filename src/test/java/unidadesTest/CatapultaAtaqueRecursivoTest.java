package unidadesTest;

import modelo.celda.Adyacentes;
import modelo.celda.Posicion;
import modelo.equipo.Equipo;
import junit.framework.TestCase;
import modelo.celda.Celda;
import modelo.unidad.*;
import java.util.*;

public class CatapultaAtaqueRecursivoTest extends TestCase {

    public void test00CatapultaAtacaAUnidadLejanaYHaceDanioASusAdyacentes() throws Exception {

        List<Celda> listaDeAdyacentes = new ArrayList<>();
        Adyacentes adyacentes = new Adyacentes(listaDeAdyacentes);
        Catapulta catapulta = new Catapulta();

        for (int i = 0; i < 4; i++) {
            Celda celda = new Celda(new Posicion(), adyacentes);
            celda.colocarUnidad(new Soldado(celda, new Equipo()));
            listaDeAdyacentes.add(celda);
        }

        catapulta.interactuar(listaDeAdyacentes.get(0).verUnidad(), 7);

        for (int i = 0; i < 4; i++) {
            assertEquals(80, listaDeAdyacentes.get(i).verUnidad().getVida());
        }

    }

    public void test01CatapultaAtacaUnidadesAdyacentesAPesarDeSuEquipo() throws Exception{

        List<Celda> listaDeAdyacentes = new ArrayList<>();
        Adyacentes adyacentes = new Adyacentes(listaDeAdyacentes);
        Catapulta catapulta = new Catapulta();
        Equipo aliado = new Equipo();
        Equipo enemigo = new Equipo();

        Celda celdaAliada = new Celda(new Posicion(), adyacentes);
        celdaAliada.colocarUnidad(new Soldado(celdaAliada, aliado));
        listaDeAdyacentes.add(celdaAliada);

        for (int i = 1; i < 5; i++) {
            Celda celda = new Celda(new Posicion(), adyacentes);
            celda.colocarUnidad(new Soldado(celda, enemigo));
            listaDeAdyacentes.add(celda);
        }

        catapulta.interactuar(listaDeAdyacentes.get(0).verUnidad(), 7);

        for (int i = 0; i < 5; i++) {
            assertEquals(80, listaDeAdyacentes.get(i).verUnidad().getVida());
        }
    }
}
