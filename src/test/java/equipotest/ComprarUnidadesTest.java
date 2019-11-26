package equipotest;

import modelo.ErroresYExcepciones.*;

import junit.framework.Assert;
import junit.framework.TestCase;
import modelo.equipo.Equipo;

public class ComprarUnidadesTest extends TestCase{

    public void test00SeCreaEquipoYLaReferenciaNoEsVacia() {

        Equipo equipo = new Equipo();
        Assert.assertNotNull( equipo );
    }

    public void test01EquipoNuevoTieneTodosSusPuntos(){

        Equipo equipo = new Equipo();
        assertEquals (20, equipo.getPuntaje());
    }

    public void test02EquipoCompraUnSoldado() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();
        equipo.comprarUnidad("soldado");

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.getCantidadUnidades());
        assertEquals ( 19, equipo.getPuntaje());
    }

    public void test03EquipoCompraUnaCatapulta() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();
        equipo.comprarUnidad("CATAPulta");

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.getCantidadUnidades());
        assertEquals ( 15, equipo.getPuntaje());
    }

    public void test04EquipoCompraUnJinete() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();
        equipo.comprarUnidad("JiNeTe");

        assertTrue (equipo.tieneUnidades());
        assertEquals (1, equipo.getCantidadUnidades());
        assertEquals ( 17, equipo.getPuntaje());
    }

    public void test05EquipoCompraUnCurandero() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();
        equipo.comprarUnidad("curandero");

        assertTrue (equipo.tieneUnidades());
        assertEquals (1, equipo.getCantidadUnidades());
        assertEquals ( 18, equipo.getPuntaje());
    }

    public void test06EquipoGastaTodosSusPuntos() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();

        equipo.comprarUnidad("catapulta");
        equipo.comprarUnidad("catapulta");
        equipo.comprarUnidad("catapulta");
        equipo.comprarUnidad("catapulta");

        assertTrue(equipo.tieneUnidades()); //Ver
        assertEquals(4, equipo.getCantidadUnidades());
        assertEquals(0, equipo.getPuntaje());
    }

    public void test07ExcepcionEquipoIntentaExcederGastos() throws EquipoNoTienePuntosSuficientes, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();

        try {
            equipo.comprarUnidad("catapulta");
            equipo.comprarUnidad("catapulta");
            equipo.comprarUnidad("catapulta");
            equipo.comprarUnidad("catapulta");

            equipo.comprarUnidad("soldado");

            fail( "No se lanzo la excepcion." );

        }catch (EquipoNoPuedeComprarMasUnidades excepcion ) {
        }
    }

    public void test08ExcepcionEquipoNoTienePuntosSuficientes() throws EquipoQuiereCrearUnidadInvalida, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo("Alejo was here", 20);
        try {

            equipo.comprarUnidad("catapulta");
            equipo.comprarUnidad("catapulta");
            equipo.comprarUnidad("catapulta");

            equipo.comprarUnidad("jinete");
            equipo.comprarUnidad("jinete");
            fail( "No se lanzo la excepcion de puntos insuficientes." );

        }catch (EquipoNoTienePuntosSuficientes excepcion ) {
        }
    }

    public void test09EquipoExcepcionEquipoQuiereComprarUnidadInvalida() throws EquipoNoPuedeComprarMasUnidades, EquipoNoTienePuntosSuficientes {
        Equipo equipo = new Equipo("Alejo was here (again)", 20);

        try {
            equipo.comprarUnidad("Dragon");
            fail("No se lanzo la excepcion de EquipoQUiereComprarUnidadInvalida");
        } catch (EquipoQuiereCrearUnidadInvalida equipoQuiereCrearUnidadInvalida) {
        }

    }
}

