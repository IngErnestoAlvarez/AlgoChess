package unidad.accion;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import unidad.*;

public abstract class Accion {

        Rango rango;
        int puntosVida;

        public abstract void interactuar(Unidad unidad, int distancia) throws CeldaNoEstaEnRango;

        //public abstract void interactuar(ArrayList<Unidad> unidades);
}
