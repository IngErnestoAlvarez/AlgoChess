package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.unidad.*;

public class AtaqueCercano extends Accion{

    public AtaqueCercano(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(1, 2);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia, double incremento) throws RangoMuyLejano, RangoMuyCercano {
        rango.perteneceAlRango(distancia);
        unidad.recibirDanio(puntosVida*incremento);
    }

    @Override
    public String getStringAudio() {
        return "./resources/audio/sword.mp3";
    }
}
