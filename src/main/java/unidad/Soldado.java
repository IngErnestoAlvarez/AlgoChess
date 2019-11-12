package unidad;

import equipo.Equipo;
import unidad.accion.*;

public class Soldado extends Unidad {


    public Soldado(){
        precio = 1;
        vida = 100;
        accion = new AtaqueCercano(10);

    }

}
