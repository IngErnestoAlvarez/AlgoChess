package unidad.estadosJinete;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import unidad.accion.Accion;
import unidad.Unidad;

public abstract class EstadoJinete {

    Accion accion;

    public abstract EstadoJinete cambiarEstado();

    public void atacar(Unidad unidad, int distancia) throws CeldaNoEstaEnRango {

        accion.interactuar(unidad, distancia);
    }
}
