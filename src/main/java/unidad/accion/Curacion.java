package unidad.accion;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import unidad.*;

public class Curacion extends Accion {

    public Curacion(int curacionInicial){

        puntosVida = curacionInicial;
        rango = new Rango(1, 2);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {

        rango.perteneceAlRango(distancia);

        unidad.recibirCuracion(puntosVida);

    }
}
