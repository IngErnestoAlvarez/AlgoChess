package accion;

import unidad.*;

public class AtaqueCercano extends Accion{

    public AtaqueCercano(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(1, 2);
    }

    public void interactuar(Unidad unidad){
        unidad.recibirDanio(puntosVida);
    }
}
