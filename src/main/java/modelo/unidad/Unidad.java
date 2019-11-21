package modelo.unidad;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

import java.util.List;

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

    public List<Unidad> verUnidadesAdyacentes(){
        return celda.verUnidadesAdyacentes();
    }
}
