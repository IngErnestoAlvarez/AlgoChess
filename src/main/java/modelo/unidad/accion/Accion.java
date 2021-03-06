package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.unidad.*;

public abstract class Accion {

        Rango rango;
        int puntosVida;

        public abstract void interactuar(Unidad unidad, int distancia, double incremento) throws RangoMuyLejano, RangoMuyCercano;

    public abstract String getStringAudio();

    //public abstract void interactuar(ArrayList<Unidad> unidades);
}
