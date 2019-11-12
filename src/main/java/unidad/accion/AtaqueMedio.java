package unidad.accion;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import unidad.Unidad;

public class AtaqueMedio extends Accion {

    public AtaqueMedio(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(3, 5);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {
        rango.perteneceAlRango(distancia);
        unidad.recibirDanio(puntosVida);
    }
}
