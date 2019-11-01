package unidades;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

class UnidadesAtaqueTest {

    @Test
    public void test00soldadoAtacaAUnidadCercanaYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.ataqueCercano(jinete);

        assertEquals(90, jinete.getVida());

    }

    @Test
    public void test01soldadoAtacaAUnidadLejanaYNoLeHaceDanio(){


        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.ataqueLejano(jinete);

        assertEquals(100, jinete.getVida());
    }

    @Test
    public void test02JineteAtacaUnidadCercanaYLeHaceElDanioCorrecto(){

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        jinete.ataqueCercano(soldado);

        assertEquals(95, soldado.getVida());

    }

    @Test
    public void test03JineteAtacaUnidadLejanaYLeHaceElDanioCorrecto(){

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        jinete.ataqueLejano(soldado);

        assertEquals(85, soldado.getVida());

    }

    @Test
    public void test04curanderoCuraSusUnidadesYLesAumentaLaVidaCorrectamente(){

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.ataqueLejano(soldado);
        curandero.curar(soldado);

        assertEquals(100, soldado.getVida());
    }

    @Test
    public void test05catapultaAtacaUnidadLejanaYLeHaceElDanioCorrecto(){

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        catapulta.ataqueLejano(soldado);

        assertEquals(80, soldado.getVida());
    }
}