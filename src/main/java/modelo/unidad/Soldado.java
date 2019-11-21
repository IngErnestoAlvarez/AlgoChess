package modelo.unidad;

import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

public class Soldado extends Unidad {

    private static final int precioSoldado = 1;
    private static final int vidaSoldado = 100;

    public Soldado(){
        precio = precioSoldado;
        vida = vidaSoldado;
        accion = new AtaqueCercano(10);

    }

    public Soldado(Celda celda, Equipo equipo) {
        precio = precioSoldado;
        vida = vidaSoldado;
        accion = new AtaqueCercano(10);
        this.celda = celda;
        this.equipo = equipo;
    }
}
