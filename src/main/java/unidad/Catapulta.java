package unidad;


import unidad.accion.*;

public class Catapulta extends Unidad {

    public static int precio = 5;

    public Catapulta(){
        vida = 50;
        accion = new AtaqueCatapulta(20);
    }

    @Override
    public void recibirCuracion(int puntosVida){
        vida += 0;
    }

}
