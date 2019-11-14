package unidad.accion;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import unidad.Unidad;
import celda.Celda;

import java.util.*;


public class AtaqueCatapulta extends Accion{

    public AtaqueCatapulta(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(6, 40);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {

        rango.perteneceAlRango(distancia);
        unidad.recibirDanio(puntosVida);

    }

}
