package unidad.accion;

import unidad.Unidad;

public class AtaqueLejano extends Accion {

    public AtaqueLejano(int danioInicial){

        puntosVida = danioInicial;
        rango = new Rango(6, 40);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia){
        unidad.recibirDanio(puntosVida);
    }
}
