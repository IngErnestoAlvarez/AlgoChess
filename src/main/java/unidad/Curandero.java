package unidad;

import equipo.Equipo;
import unidad.accion.*;

public class Curandero extends Unidad {

    public Curandero(){
        precio = 2;
        vida = 75;
        accion = new Curacion(15);

    }


}
