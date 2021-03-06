package modelo.unidad;

import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

public class Soldado extends Unidad {

    private static final int precioSoldado = 1;
    private static final double vidaSoldado = 100;
    private static final int danio = 10;

    public Soldado(){
        precio = precioSoldado;
        vida = vidaSoldado;
        accion = new AtaqueCercano(danio);

    }

    public Soldado(Celda celda, Equipo equipo) {
        precio = precioSoldado;
        vida = vidaSoldado;
        accion = new AtaqueCercano(10);
        this.celda = celda;
        this.equipo = equipo;
    }

    public String getStringAccion(){
        return "Danio de ataque: " + danio;
    }


}
