package equipotest;

import equipo.*;
import unidad.*;
import ErroresYExcepciones.*;


import junit.framework.TestCase;

public class EquipoPierdeTest extends TestCase{

    public void test00EquipoUnidadRecibeDanioPeroNoPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {
        Equipo equipo = new Equipo();
        equipo.comprarUnidad("soldado");

        Unidad unidad = equipo.devolverUnaUnidad();
        unidad.recibirDanio(1);

        equipo.eliminarUnidadesMuertas();

        assertEquals(1, equipo.getCantidadUnidades());
        assertFalse(equipo.esPerdedor());
    }

    public void test01EquipoConVariasUnidadesPierdeUnaPeroNoPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();

        equipo.comprarUnidad("soldado");
        equipo.comprarUnidad("catapulTA");
        equipo.comprarUnidad("JINETE");

        Unidad unidad = equipo.devolverUnaUnidad();
        unidad.recibirDanio(100);

        equipo.eliminarUnidadesMuertas();

        assertEquals(2,equipo.getCantidadUnidades());
        assertFalse(equipo.esPerdedor());
    }

    public void test02EquipoPierdeTodasSusUnidadesYPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();

        equipo.comprarUnidad("soldado");
        equipo.comprarUnidad("Jinete");

        Unidad unidad = equipo.devolverUnaUnidad();
        unidad.recibirDanio(100);

        equipo.eliminarUnidadesMuertas();

        assertEquals(1,equipo.getCantidadUnidades());
        assertFalse(equipo.esPerdedor());

        Unidad otraUnidad = equipo.devolverUnaUnidad();
        otraUnidad.recibirDanio(150);
        equipo.eliminarUnidadesMuertas();

        assertEquals(0,equipo.getCantidadUnidades());
        assertTrue(equipo.esPerdedor());
    }
}


