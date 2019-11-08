package unidad;

import unidad.accion.*;

public class Curandero extends Unidad {

    public Curandero(){
        precio = 2;
        vida = 75;
        accion = new Curacion(15);
    }


    public void interactuar(Unidad unidad) {

        accion.interactuar(unidad);
    }
}
