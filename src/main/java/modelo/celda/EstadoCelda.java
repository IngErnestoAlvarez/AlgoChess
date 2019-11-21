package modelo.celda;

import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.CeldaYaTieneUnidad;
import modelo.unidad.Unidad;

public interface  EstadoCelda {
    void colocarUnidad(Celda celda, Unidad unidad) throws CeldaYaTieneUnidad;
    Unidad quitarUnidad(Celda celda) throws CeldaNoTieneUnidad;
    Unidad verUnidad() throws CeldaNoTieneUnidad;
}
