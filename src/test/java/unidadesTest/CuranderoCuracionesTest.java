package unidadesTest;

import ErroresYExcepciones.CuranderoNoPuedeCurarDeLejos;
import ErroresYExcepciones.CuranderoNoPuedeCurarUnaCatapulta;
import junit.framework.TestCase;

import unidades.*;

public class CuranderoCuracionesTest extends TestCase {

    public void test01CuranderoNoPuedeCurarUnaCatapulta(){

        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();

        soldado.ataqueCercano(catapulta);


        try{
            curandero.curarCercano(catapulta);

        }
        catch(CuranderoNoPuedeCurarUnaCatapulta e) {}

        assertEquals(40, catapulta.getVida());
        }

        public void test02CuranderoNoPuedeCurarDeLejos(){

                Curandero curandero = new Curandero();
                Soldado soldado = new Soldado();
                Jinete jinete = new Jinete();

                jinete.ataqueCercano(soldado);
            try{
                curandero.curarLejano(soldado);
            }catch(CuranderoNoPuedeCurarDeLejos e){}

            assertEquals(95, soldado.getVida());
        }


    public void test03CuranderoCuraSoldadoLaVidaCorrecta(){

        try {
            Curandero curandero = new Curandero();
            Soldado soldado1 = new Soldado();
            Soldado soldado2 = new Soldado();

            soldado1.ataqueCercano(soldado2);

            curandero.curarCercano(soldado2);

            assertEquals(105, soldado2.getVida());
        }
        catch(CuranderoNoPuedeCurarUnaCatapulta e){}


    }

    public void test04CuranderoCuraJineteLaVidaCorrecta(){
        try {
            Curandero curandero = new Curandero();
            Jinete jinete= new Jinete();
            Soldado soldado = new Soldado();

            soldado.ataqueCercano(jinete);

            curandero.curarCercano(jinete);

            assertEquals(105, jinete.getVida());
        }
        catch(CuranderoNoPuedeCurarUnaCatapulta e){}
    }

    public void test05CuranderoCuraCuranderoLaVidaCorrecta(){

        try {
            Curandero curandero1 = new Curandero();
            Soldado soldado = new Soldado();
            Curandero curandero2 = new Curandero();

            soldado.ataqueCercano(curandero2);

            curandero1.curarCercano(curandero2);

            assertEquals(80, curandero2.getVida());
        }
        catch(CuranderoNoPuedeCurarUnaCatapulta e){}
    }
}
