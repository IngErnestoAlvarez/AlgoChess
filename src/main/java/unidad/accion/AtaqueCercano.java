package unidad.accion;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import unidad.*;

public class AtaqueCercano extends Accion{

    public AtaqueCercano(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(1, 2);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {
        rango.perteneceAlRango(distancia);
        unidad.recibirDanio(puntosVida);
    }
}
