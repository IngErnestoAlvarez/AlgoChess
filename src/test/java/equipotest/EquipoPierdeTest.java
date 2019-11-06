package equipotest;

import equipo.*;
import unidad.*;
import ErroresYExcepciones.*;


import junit.framework.TestCase;

public class EquipoPierdeTest extends TestCase{

    public void test00EquipoUnidadRecibeDanioPeroNoPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {
        Equipo equipo = new Equipo();
        equipo.comprarSoldado();

        Unidad unidad = equipo.devolverUnaUnidad();
        unidad.recibirDanio(1);

        equipo.eliminarUnidadesMuertas();

        assertEquals(1, equipo.cantidadUnidades());
        assertFalse(equipo.esPerdedor());
    }

    public void test01EquipoConVariasUnidadesPierdeUnaPeroNoPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();

        equipo.comprarSoldado();
        equipo.comprarCatapulta();
        equipo.comprarJinete();

        Unidad unidad = equipo.devolverUnaUnidad();
        unidad.recibirDanio(100);

        equipo.eliminarUnidadesMuertas();

        assertEquals(2,equipo.cantidadUnidades());
        assertFalse(equipo.esPerdedor());
    }

    public void test02EquipoPierdeTodasSusUnidadesYPierde() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        Equipo equipo = new Equipo();

        equipo.comprarSoldado();
        equipo.comprarJinete();

        Unidad unidad = equipo.devolverUnaUnidad();
        unidad.recibirDanio(100);

        equipo.eliminarUnidadesMuertas();

        assertEquals(1,equipo.cantidadUnidades());
        assertFalse(equipo.esPerdedor());

        Unidad otraUnidad = equipo.devolverUnaUnidad();
        otraUnidad.recibirDanio(150);
        equipo.eliminarUnidadesMuertas();

        assertEquals(0,equipo.cantidadUnidades());
        assertTrue(equipo.esPerdedor());
    }
}



