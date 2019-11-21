package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;

public class Rango {

    private int rangoMaximo;
    private int rangoMinimo;

    public Rango(int min, int max){
        rangoMaximo = max;
        rangoMinimo = min;
    }

    public boolean perteneceAlRango(int distancia) throws RangoMuyLejano, RangoMuyCercano {

        if(distancia > rangoMaximo){
            throw new RangoMuyLejano();
        }
        else if(distancia < rangoMinimo){
            throw new RangoMuyCercano();
        }
        return true;
    }
}
