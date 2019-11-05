package accion;

import unidades.Unidad;

public class AtaqueLejano extends Accion {

    public AtaqueLejano(int danioInicial){

        puntosVida = danioInicial;
        rango = new Rango(6, 40);
    }

    public void interactuar(Unidad unidad){
        unidad.recibirDanio(puntosVida);
    }
}
