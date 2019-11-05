package unidades;

import accion.*;

public class Soldado extends Unidad {

    public static int precio = 1;

    public Soldado(){
        vida = 100;
        accion = new AtaqueCercano(10);
    }

}
