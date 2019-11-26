package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.unidad.Unidad;

public class AtaqueMedio extends Accion {

    public AtaqueMedio(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(3, 5);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia, double incremento) throws RangoMuyLejano, RangoMuyCercano {
        rango.perteneceAlRango(distancia);
        unidad.recibirDanio(puntosVida*incremento);
    }
}
