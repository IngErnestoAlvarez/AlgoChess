package unidad;

import accion.*;

public class Curandero extends Unidad {

    public static int precio = 2;

    public Curandero(){
        vida = 75;
        accion = new Curacion(15);
    }


    public void interactuar(Unidad unidad) {

        accion.interactuar(unidad);
    }
}
