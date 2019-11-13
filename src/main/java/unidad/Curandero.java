package unidad;

import celda.Celda;
import equipo.Equipo;
import unidad.accion.*;

public class Curandero extends Unidad {

    private static final int precioCurandero = 2;
    private static final int vidaCurandero = 75;

    public Curandero(){
        precio = precioCurandero;
        vida = vidaCurandero;
        accion = new Curacion(15);
    }

    public Curandero(Celda celda, Equipo equipo){
        precio = precioCurandero;
        vida = vidaCurandero;
        accion = new Curacion(15);
        this.celda = celda;
        this.equipo = equipo;
    }

}
