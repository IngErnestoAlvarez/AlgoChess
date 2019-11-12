package unidad.accion;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import unidad.*;

public abstract class Accion {

        Rango rango;
        int puntosVida;

        public abstract void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano;

        //public abstract void interactuar(ArrayList<Unidad> unidades);
}
