package unidad.accion;

import unidad.Unidad;

public class AtaqueCatapulta extends Accion{

    public AtaqueCatapulta(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(6, 40);
    }

    public void interactuar(Unidad unidad){
        unidad.recibirDanio(puntosVida);
    }
}
