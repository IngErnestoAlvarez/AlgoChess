package equipotest;

import modelo.equipo.*;
import modelo.unidad.*;
import modelo.ErroresYExcepciones.*;


import junit.framework.TestCase;

public class EquipoPierdeTest extends TestCase{

    public void test00EquipoUnidadRecibeDanioPeroNoPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {
        Equipo equipo = new Equipo();
        Unidad unidad = equipo.comprarUnidad("soldado");

        unidad.recibirDanio(1);

        equipo.eliminarUnidadesMuertas();

        assertEquals(1, equipo.getCantidadUnidades());
        assertFalse(equipo.esPerdedor());
    }

    public void test01EquipoConVariasUnidadesPierdeUnaPeroNoPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();

        Unidad unidad = equipo.comprarUnidad("soldado");
        equipo.comprarUnidad("catapulTA");
        equipo.comprarUnidad("JINETE");

        unidad.recibirDanio(100);

        equipo.eliminarUnidadesMuertas();

        assertEquals(2,equipo.getCantidadUnidades());
        assertFalse(equipo.esPerdedor());
    }

    public void test02EquipoPierdeTodasSusUnidadesYPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades, EquipoQuiereCrearUnidadInvalida {

        Equipo equipo = new Equipo();

        Unidad unidad = equipo.comprarUnidad("soldado");
        Unidad otraUnidad = equipo.comprarUnidad("Jinete");

        unidad.recibirDanio(100);

        equipo.eliminarUnidadesMuertas();

        assertEquals(1,equipo.getCantidadUnidades());
        assertFalse(equipo.esPerdedor());

        otraUnidad.recibirDanio(150);
        equipo.eliminarUnidadesMuertas();

        assertEquals(0,equipo.getCantidadUnidades());
        assertTrue(equipo.esPerdedor());
    }
}


