package modelo.unidad;


import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

public class Catapulta extends Unidad {

    private static final int precioCatapulta = 5;
    private static final double vidaCatapulta = 50;

    public Catapulta(){
        precio = precioCatapulta;
        vida = vidaCatapulta;
        accion = new AtaqueCatapulta(20);
    }

    public Catapulta(Celda celda, Equipo equipo){
        precio = precioCatapulta;
        vida = vidaCatapulta;
        accion = new AtaqueCatapulta(20);
        this.celda = celda;
        this.equipo = equipo;
    }

    @Override
    public void recibirCuracion(double puntosVida){
        vida += 0;
    }
}
