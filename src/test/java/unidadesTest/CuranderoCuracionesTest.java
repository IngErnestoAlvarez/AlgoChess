
package unidadesTest;

import junit.framework.TestCase;

import unidad.*;

public class CuranderoCuracionesTest extends TestCase {

    public void test01CuranderoNoPuedeCurarUnaCatapulta(){

        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        soldado.interactuar(catapulta);

        curandero.interactuar(catapulta);

        assertEquals(40, catapulta.getVida());
        }


    public void test03CuranderoCuraSoldadoLaVidaCorrecta(){
        Curandero curandero = new Curandero();
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();

        soldado1.interactuar(soldado2);

        curandero.interactuar(soldado2);

        assertEquals(105, soldado2.getVida());

    }

    public void test04CuranderoCuraJineteLaVidaCorrecta(){
        Curandero curandero = new Curandero();
        Jinete jinete= new Jinete();
        Soldado soldado = new Soldado();

        soldado.interactuar(jinete);

        curandero.interactuar(jinete);

        assertEquals(105, jinete.getVida());

    }

    public void test05CuranderoCuraCuranderoLaVidaCorrecta(){

        Curandero curandero1 = new Curandero();
        Soldado soldado = new Soldado();
        Curandero curandero2 = new Curandero();

        soldado.interactuar(curandero2);

        curandero1.interactuar(curandero2);

        assertEquals(80, curandero2.getVida());
    }
}

