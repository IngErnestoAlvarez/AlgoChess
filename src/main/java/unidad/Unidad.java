package unidad;

import unidad.accion.*;

public abstract class Unidad {

    int vida;
    int precio;
    Accion accion;

    public int getVida(){
        return vida;
    }
    
    public getPrecio(){
        return precio;
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
