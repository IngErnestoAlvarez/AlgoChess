package accion;

import unidad.*;

public abstract class Accion {

        Rango rango;
        int puntosVida;

        public abstract void interactuar(Unidad unidad);

        //public abstract void interactuar(ArrayList<Unidad> unidades);
}
