package celdatest;

import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.celda.EstadoCelda;
import modelo.celda.EstadoCeldaVacia;
import junit.framework.TestCase;

public class EstadoJineteCeldaTest extends TestCase {

    public void test00EstadoCeldaVaciaNoSePuedeVerUnidad(){
        EstadoCelda estadoCelda = new EstadoCeldaVacia();

        try{
           estadoCelda.verUnidad();
           fail("No lanzó la excepcion que se esperaba");
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {}
    }


}
