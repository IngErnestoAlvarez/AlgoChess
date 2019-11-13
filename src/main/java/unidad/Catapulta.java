package unidad;


import celda.Celda;
import equipo.Equipo;
import unidad.accion.*;

public class Catapulta extends Unidad {

    private static final int precioCatapulta = 5;
    private static final int vidaCatapulta = 50;

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
    public void recibirCuracion(int puntosVida){
        vida += 0;
    }

}
