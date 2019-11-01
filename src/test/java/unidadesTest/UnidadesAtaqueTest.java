package unidadesTest;


import junit.framework.TestCase;
import unidades.*;

public class UnidadesAtaqueTest extends TestCase {


    public void test00soldadoAtacaAUnidadCercanaYLeQuitaLaVidaCorrecta() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.ataqueCercano(jinete);

        assertEquals(90, jinete.getVida());

    }


    public void test01soldadoAtacaAUnidadLejanaYNoLeHaceDanio(){


        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        soldado.ataqueLejano(jinete);

        assertEquals(100, jinete.getVida());
    }


    public void test02JineteAtacaUnidadCercanaYLeHaceElDanioCorrecto(){

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        jinete.ataqueCercano(soldado);

        assertEquals(95, soldado.getVida());

    }


    public void test03JineteAtacaUnidadLejanaYLeHaceElDanioCorrecto(){

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();

        jinete.ataqueLejano(soldado);

        assertEquals(85, soldado.getVida());

    }


    public void test04curanderoCuraSusUnidadesYLesAumentaLaVidaCorrectamente(){

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        jinete.ataqueLejano(soldado);
        curandero.curar(soldado);

        assertEquals(100, soldado.getVida());
    }


    public void test05catapultaAtacaUnidadLejanaYLeHaceElDanioCorrecto(){

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();

        catapulta.ataqueLejano(soldado);

        assertEquals(80, soldado.getVida());
    }
}