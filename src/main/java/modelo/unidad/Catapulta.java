package modelo.unidad;


import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

public class Catapulta extends Unidad {

    private static final int precioCatapulta = 5;
    private static final double vidaCatapulta = 50;
    private static final int danio = 20;

    public Catapulta(){
        precio = precioCatapulta;
        vida = vidaCatapulta;
        accion = new AtaqueCatapulta(danio);
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

    public String getStringAccion(){
        return "Danio de ataque: " + danio;
    }
}
