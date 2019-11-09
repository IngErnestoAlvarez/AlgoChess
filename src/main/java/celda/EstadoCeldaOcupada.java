package celda;

import ErroresYExcepciones.CeldaNoTieneUnidad;
import ErroresYExcepciones.CeldaYaTieneUnidad;
import unidad.Unidad;

public class EstadoCeldaOcupada implements EstadoCelda {

    private Unidad unidad;

    public EstadoCeldaOcupada(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public void colocarUnidad(Celda celda, Unidad unidad) throws CeldaYaTieneUnidad {
        throw new CeldaYaTieneUnidad();
    }

    @Override
    public Unidad quitarUnidad(Celda celda) throws CeldaNoTieneUnidad {
        celda.estado = new EstadoCeldaVacia();
        return this.unidad;
    }

    @Override
    public Unidad verUnidad() throws CeldaNoTieneUnidad {
        return this.unidad;
    }
}
