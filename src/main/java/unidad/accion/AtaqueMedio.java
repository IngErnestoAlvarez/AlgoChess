package unidad.accion;

import unidad.Unidad;

public class AtaqueMedio extends Accion {

    public AtaqueMedio(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(3, 5);
    }

    public void interactuar(Unidad unidad){
        unidad.recibirDanio(puntosVida);
    }
}
