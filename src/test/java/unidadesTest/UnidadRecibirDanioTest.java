package unidadesTest;

import junit.framework.TestCase;
import unidad.*;

public class UnidadRecibirDanioTest extends TestCase{

    public void test01SoldadoRecibeElDanioCorrecto(){

        Soldado soldado = new Soldado();
        int vida = soldado.getVida();
        soldado.recibirDanio(20);

        assertEquals(vida - 20, soldado.getVida());

    }
    public void test02JineteRecibeElDanioCorrecto(){

        Jinete jinete = new Jinete();
        int vida = jinete.getVida();
        jinete.recibirDanio(20);

        assertEquals(vida - 20, jinete.getVida());

    }
    public void test03CuranderoRecibeElDanioCorrecto(){

        Curandero curandero = new Curandero();
        int vida = curandero.getVida();
        curandero.recibirDanio(20);

        assertEquals(vida - 20, curandero.getVida());

    }
    public void test04CatapultaRecibeElDanioCorrecto(){

       Catapulta catapulta = new Catapulta();
        int vida = catapulta.getVida();
        catapulta.recibirDanio(20);

        assertEquals(vida - 20, catapulta.getVida());

    }
}
