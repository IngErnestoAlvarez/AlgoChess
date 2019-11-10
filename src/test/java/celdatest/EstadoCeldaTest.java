package celdatest;

import ErroresYExcepciones.CeldaNoTieneUnidad;
import celda.EstadoCelda;
import celda.EstadoCeldaVacia;
import junit.framework.TestCase;

public class EstadoCeldaTest extends TestCase {

    public void test00EstadoCeldaVaciaNoSePuedeVerUnidad(){
        EstadoCelda estadoCelda = new EstadoCeldaVacia();

        try{
           estadoCelda.verUnidad();
           fail("No lanzó la excepcion que se esperaba");
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {}
    }


}
