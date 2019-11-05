package unidades;

import accion.*;

public abstract class Unidad {

    int vida;
    static int precio;
    Accion accion;

    public int getVida(){
        return vida;
    }

    public void interactuar(Unidad unidad){
        accion.interactuar(unidad);
    }

    public void recibirCuracion(int vidaCurada){
        vida += vidaCurada;
    }

    public void recibirDanio(int danio){
        vida -= danio;
    }

}
