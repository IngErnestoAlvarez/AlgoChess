package unidad;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import celda.Celda;
import equipo.Equipo;
import unidad.accion.*;

public abstract class Unidad {

    int vida;
    int precio;
    Accion accion;
    Equipo equipo;
    Celda celda;

    public int getVida(){
        return vida;
    }
    
    public int getPrecio(){
        return precio;
    }

    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {
        accion.interactuar(unidad, distancia);
    }

    public void recibirCuracion(int vidaCurada){
        vida += vidaCurada;
    }

    public void recibirDanio(int danio){
        vida -= danio;
    }

    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }

    protected Equipo verEquipo() {
        return this.equipo;
    }
}
