package unidad.accion;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import unidad.*;

public class AtaqueCercano extends Accion{

    public AtaqueCercano(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(1, 2);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws CeldaNoEstaEnRango {
        if(rango.perteneceAlRango(distancia)){
            unidad.recibirDanio(puntosVida);
        }
        else{
            throw new CeldaNoEstaEnRango();
        }
    }
}
