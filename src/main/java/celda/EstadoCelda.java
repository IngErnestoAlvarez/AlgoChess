package celda;

import ErroresYExcepciones.CeldaNoTieneUnidad;
import ErroresYExcepciones.CeldaYaTieneUnidad;
import unidad.Unidad;

public interface  EstadoCelda {
    void colocarUnidad(Celda celda, Unidad unidad) throws CeldaYaTieneUnidad;
    Unidad quitarUnidad(Celda celda) throws CeldaNoTieneUnidad;
    Unidad verUnidad() throws CeldaNoTieneUnidad;
}
