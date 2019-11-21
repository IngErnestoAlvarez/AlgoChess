package modelo.celda;

import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.unidad.Unidad;

public class EstadoCeldaVacia implements EstadoCelda{

    public EstadoCeldaVacia(){}

    @Override
    public void colocarUnidad(Celda celda, Unidad unidad){
        celda.estado = new EstadoCeldaOcupada(unidad);
    }

    @Override
    public Unidad quitarUnidad(Celda celda) throws CeldaNoTieneUnidad {
        throw new CeldaNoTieneUnidad();
    }

    @Override
    public Unidad verUnidad() throws CeldaNoTieneUnidad {
        throw new CeldaNoTieneUnidad();
    }
}
