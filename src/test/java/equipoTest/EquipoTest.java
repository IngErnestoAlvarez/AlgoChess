package equipoTest;

import equipo.*;
import ErroresYExcepciones.*;

import junit.framework.Assert;
import junit.framework.TestCase;

public class EquipoTest extends TestCase{

    public void test00SeCreaEquipoYLaReferenciaNoEsVacia() {

        Equipo equipo = new Equipo();
        Assert.assertNotNull( equipo );
    }

    public void test01EquipoNuevoTieneTodosSusPuntos(){

        Equipo equipo = new Equipo();
        assertEquals (20, equipo.verPuntaje());
    }

    public void test02EquipoCompraUnSoldado() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();
        equipo.comprarSoldado();

        assertTrue (equipo.tieneUnidades()); //Ver
        //assertEquals (1, equipo.cantidadUnidades());
        //assertEquals ( 19, equipo.verPuntaje());
    }

    public void test03EquipoCompraUnaCatapulta() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();
        equipo.comprarCatapulta();

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 15, equipo.verPuntaje());
    }

    public void test04EquipoCompraUnJinete() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();
        equipo.comprarJinete();

        assertTrue (equipo.tieneUnidades());
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 17, equipo.verPuntaje());
    }

    public void test05EquipoCompraUnCurandero() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();
        equipo.comprarCurandero();

        assertTrue (equipo.tieneUnidades());
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 18, equipo.verPuntaje());
    }

    public void test06EquipoGastaTodosSusPuntos() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();

        equipo.comprarCatapulta();
        equipo.comprarCatapulta();
        equipo.comprarCatapulta();
        equipo.comprarCatapulta();

        assertTrue(equipo.tieneUnidades()); //Ver
        //assertEquals(4, equipo.cantidadUnidades());
        //assertEquals(0, equipo.verPuntaje());
    }

    public void test07ExcepcionEquipoIntentaExcederGastos() throws EquipoNoTienePuntosSuficientes {

        Equipo equipo = new Equipo();

        try {
            equipo.comprarCatapulta();
            equipo.comprarCatapulta();
            equipo.comprarCatapulta();
            equipo.comprarCatapulta();

            equipo.comprarSoldado();
            fail( "No se lanzo la excepcion." );

        }catch (EquipoNoPuedeComprarMasUnidades excepcion ) {
        }
    }

    public void test08ExcepcionEquipoNoTienePuntosSuficientes() throws EquipoNoTienePuntosSuficientes{

        Equipo equipo = new Equipo();
        try {

            equipo.comprarCatapulta();
            equipo.comprarCatapulta();
            equipo.comprarCatapulta();
            equipo.comprarCatapulta();

            equipo.comprarJinete();
            fail( "No se lanzo la excepcion." );
        }catch (EquipoNoPuedeComprarMasUnidades excepcion ) {
        }
    }
}
