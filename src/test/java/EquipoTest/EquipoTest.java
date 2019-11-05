package EquipoTest;

import Equipo.Equipo;
import Unidad.Soldado;
import Unidad.Catapulta;
import Unidad.Jinete;
import Unidad.Curandero;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EquipoTest extends TestCase{

    public void testSeCreaEquipoYLaReferenciaNoEsVacia() {

        Equipo equipo = new Equipo();
        Assert.assertNotNull( equipo );
    }

    public void testEquipoNuevoTieneTodosSusPuntos(){

        Equipo equipo = new Equipo();
        assertEquals (20, equipo.verPuntaje());
    }

    public void testEquipoCompraUnSoldado(){

        Equipo equipo = new Equipo();
        Soldado soldado = new Soldado();

        equipo.comprarUnidad( soldado );

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 19, equipo.verPuntaje());
    }

    public void testEquipoCompraUnaCatapulta(){

        Equipo equipo = new Equipo();
        Catapulta catapulta = new Catapulta();

        equipo.comprarUnidad( catapulta );

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 15, equipo.verPuntaje());
    }

    public void testEquipoCompraUnJinete(){

        Equipo equipo = new Equipo();
        Jinete jinete = new Jinete();

        equipo.comprarJinete(jinete);

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 17, equipo.verPuntaje());
    }

    public void testEquipoCompraUnCurandero(){

        Equipo equipo = new Equipo();
        Curandero curandero = new Curandero();

        equipo.comprarUnidad( curandero );

        assertTrue (equipo.tieneUnidades()); //Ver
        assertEquals (1, equipo.cantidadUnidades());
        assertEquals ( 18, equipo.verPuntaje());
    }

    public void testEquipoGastaTodosSusPuntos() {

        Equipo equipo = new Equipo();

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();
        Catapulta catapulta3 = new Catapulta();
        Catapulta catapulta4 = new Catapulta();

        equipo.comprarUnidad(catapulta1);
        equipo.comprarUnidad(catapulta2);
        equipo.comprarUnidad(catapulta3);
        equipo.comprarUnidad(catapulta4);

        assertTrue(equipo.tieneUnidades()); //Ver
        assertEquals(4, equipo.cantidadUnidades());
        assertEquals(0, equipo.verPuntaje());
    }

    public void testExcepcionEquipoIntentaExcederGastos() {

        Equipo equipo = new Equipo();

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();
        Catapulta catapulta3 = new Catapulta();
        Catapulta catapulta4 = new Catapulta();
        Soldado soldado = new Soldado();


        equipo.comprarUnidad(catapulta1);
        equipo.comprarUnidad(catapulta2);
        equipo.comprarUnidad(catapulta3);
        equipo.comprarUnidad(catapulta4);

        try {
            equipo.comprarUnidad(soldado);
            fail( "No se lanzo la excepcion." );
        } catch EquipoNoPuedeComprarMasUnidades excepcion ) {
        }
    }

    public void testExcepcionEquipoNoTienePuntosSuficientes(){
        Equipo equipo = new Equipo();

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();
        Catapulta catapulta3 = new Catapulta();
        Jinete jinete1 = new Jinete();
        Jinete jinete2 = new Jinete();

        equipo.comprarUnidad(catapulta1); //5
        equipo.comprarUnidad(catapulta2);
        equipo.comprarUnidad(catapulta3);
        equipo.comprarUnidad(jinete1); //3
        /*
         * 18 puntos gastados. Quedan 3.
         */

        try {
            equipo.comprarUnidad(jinete2);
            fail( "No se lanzo la excepcion." );
        } catch (EquipoNoPuedeComprarMasUnidades excepcion ) {
        }

    }
}
