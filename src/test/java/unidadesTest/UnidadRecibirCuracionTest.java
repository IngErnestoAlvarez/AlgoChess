package unidadesTest;

import junit.framework.TestCase;
import unidad.*;

public class UnidadRecibirCuracionTest extends TestCase{

    public void test01SoldadoRecibeLaCuracionCorrecta(){

        Soldado soldado = new Soldado();
        int vida = soldado.getVida();
        soldado.recibirCuracion(20);

        assertEquals(vida + 20, soldado.getVida());

    }
    public void test02JineteRecibeLaCuracionCorrecta(){

        Jinete jinete = new Jinete();
        int vida = jinete.getVida();
        jinete.recibirCuracion(20);

        assertEquals(vida + 20, jinete.getVida());

    }
    public void test03CuranderoRecibeLaCuracionCorrecta(){

        Curandero curandero = new Curandero();
        int vida = curandero.getVida();
        curandero.recibirCuracion(20);

        assertEquals(vida + 20, curandero.getVida());

    }
    public void test04CatapultaNoRecibeCuracion(){

        Catapulta catapulta = new Catapulta();
        int vida = catapulta.getVida();
        catapulta.recibirCuracion(20);

        assertEquals(vida, catapulta.getVida());

    }
}
