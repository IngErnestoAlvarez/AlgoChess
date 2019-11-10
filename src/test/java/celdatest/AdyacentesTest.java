package celdatest;

import ErroresYExcepciones.CeldaYaTieneUnidad;
import celda.Adyacentes;
import celda.Celda;
import junit.framework.TestCase;
import unidad.*;

import java.util.ArrayList;
import java.util.List;

public class AdyacentesTest extends TestCase {
    public void test00AdyacentesSeVeLaUnidadDeUnAdyacente() throws CeldaYaTieneUnidad {
        Celda celdaAdyacente1 = new Celda();
        Celda celdaAdyacente2 = new Celda();

        List<Celda> listaDeAdyacentes = new ArrayList<Celda>();

        listaDeAdyacentes.add(celdaAdyacente1);
        listaDeAdyacentes.add(celdaAdyacente2);

        Unidad unidadDePrueba = new Soldado();

        celdaAdyacente1.colocarUnidad(unidadDePrueba);

        Adyacentes adyacentes = new Adyacentes(listaDeAdyacentes);

        assertTrue(adyacentes.verUnidadesAdyacentes().contains(unidadDePrueba));

    }

    public void test01AdyacentesSeVenDosUnidadesDeUnAdyacente() throws CeldaYaTieneUnidad {
        Celda celdaAdyacente1 = new Celda();
        Celda celdaAdyacente2 = new Celda();

        List<Celda> listaDeAdyacentes = new ArrayList<Celda>();

        listaDeAdyacentes.add(celdaAdyacente1);
        listaDeAdyacentes.add(celdaAdyacente2);

        Unidad unidadDePrueba1 = new Soldado();
        Unidad unidadDePrueba2 = new Catapulta();

        celdaAdyacente1.colocarUnidad(unidadDePrueba1);
        celdaAdyacente2.colocarUnidad(unidadDePrueba2);

        Adyacentes adyacentes = new Adyacentes(listaDeAdyacentes);

        assertTrue(adyacentes.verUnidadesAdyacentes().contains(unidadDePrueba1));
        assertTrue(adyacentes.verUnidadesAdyacentes().contains(unidadDePrueba2));

    }

}
