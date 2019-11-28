package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.unidad.*;

public class Curacion extends Accion {

    public Curacion(int curacionInicial){

        puntosVida = curacionInicial;
        rango = new Rango(1, 2);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia, double incremento) throws RangoMuyLejano, RangoMuyCercano {

        rango.perteneceAlRango(distancia);

        unidad.recibirCuracion(puntosVida);

    }

    @Override
    public String getStringAudio() {
        return "./resources/audio/heal.mp3";
    }
}
