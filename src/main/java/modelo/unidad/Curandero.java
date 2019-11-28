package modelo.unidad;

import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

public class Curandero extends Unidad {

    private static final int precioCurandero = 2;
    private static final double vidaCurandero = 75;
    private static final int curacion = 15;

    public Curandero(){
        precio = precioCurandero;
        vida = vidaCurandero;
        accion = new Curacion(curacion);
    }

    public Curandero(Celda celda, Equipo equipo){
        precio = precioCurandero;
        vida = vidaCurandero;
        accion = new Curacion(15);
        this.celda = celda;
        this.equipo = equipo;
    }

    public String getStringAccion(){
        return "Vida que cura: " + curacion;
    }

}
