package unidad.accion;

import unidad.Unidad;

public class AtaqueCatapulta extends Accion{

    public AtaqueCatapulta(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(6, 40);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia){
        unidad.recibirDanio(puntosVida);
    }
}
