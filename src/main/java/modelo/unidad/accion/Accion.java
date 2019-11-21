package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.unidad.*;

public abstract class Accion {

        Rango rango;
        int puntosVida;

        public abstract void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano;

        //public abstract void interactuar(ArrayList<Unidad> unidades);
}
