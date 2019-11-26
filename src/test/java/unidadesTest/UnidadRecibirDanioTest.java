package unidadesTest;

import junit.framework.TestCase;
import modelo.unidad.*;

public class UnidadRecibirDanioTest extends TestCase{

    public void test01SoldadoRecibeElDanioCorrecto(){

        Soldado soldado = new Soldado();
        double vida = soldado.getVida();
        soldado.recibirDanio(20.0);

        assertEquals(vida - 20.0, soldado.getVida());

    }
    public void test02JineteRecibeElDanioCorrecto(){

        Jinete jinete = new Jinete();
        double vida = jinete.getVida();
        jinete.recibirDanio(20.0);

        assertEquals(vida - 20.0, jinete.getVida());

    }
    public void test03CuranderoRecibeElDanioCorrecto(){

        Curandero curandero = new Curandero();
        double vida = curandero.getVida();
        curandero.recibirDanio(20.0);

        assertEquals(vida - 20.0, curandero.getVida());

    }
    public void test04CatapultaRecibeElDanioCorrecto(){

       Catapulta catapulta = new Catapulta();
        double vida = catapulta.getVida();
        catapulta.recibirDanio(20.0);

        assertEquals(vida - 20.0, catapulta.getVida());

    }
}
