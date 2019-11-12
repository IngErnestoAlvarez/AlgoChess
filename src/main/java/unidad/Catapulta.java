package unidad;


import equipo.Equipo;
import unidad.accion.*;

public class Catapulta extends Unidad {

    public Catapulta(){
        precio = 5;
        vida = 50;
        accion = new AtaqueCatapulta(20);
    }

    @Override
    public void recibirCuracion(int puntosVida){
        vida += 0;
    }

}
