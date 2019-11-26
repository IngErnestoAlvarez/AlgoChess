package unidadesTest;

import junit.framework.TestCase;
import modelo.unidad.*;

public class UnidadRecibirCuracionTest extends TestCase{

    public void test01SoldadoRecibeLaCuracionCorrecta(){

        Soldado soldado = new Soldado();
        double vida = soldado.getVida();
        soldado.recibirCuracion(20.0);

        assertEquals(vida + 20.0, soldado.getVida());

    }
    public void test02JineteRecibeLaCuracionCorrecta(){

        Jinete jinete = new Jinete();
        double vida = jinete.getVida();
        jinete.recibirCuracion(20.0);

        assertEquals(vida + 20.0, jinete.getVida());

    }
    public void test03CuranderoRecibeLaCuracionCorrecta(){

        Curandero curandero = new Curandero();
        double vida = curandero.getVida();
        curandero.recibirCuracion(20.0);

        assertEquals(vida + 20.0, curandero.getVida());

    }
    public void test04CatapultaNoRecibeCuracion(){

        Catapulta catapulta = new Catapulta();
        double vida = catapulta.getVida();
        catapulta.recibirCuracion(20.0);

        assertEquals(vida, catapulta.getVida());

    }
}
