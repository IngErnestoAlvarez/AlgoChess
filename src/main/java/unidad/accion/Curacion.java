package unidad.accion;

import unidad.*;

public class Curacion extends Accion {

    public Curacion(int curacionInicial){

        puntosVida = curacionInicial;
        Rango rango = new Rango(0, 1);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia){
        unidad.recibirCuracion(puntosVida);
    }
}
