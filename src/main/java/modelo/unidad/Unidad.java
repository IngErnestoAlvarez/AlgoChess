package modelo.unidad;

import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.*;

import java.util.List;

public abstract class Unidad {

    double vida;
    int precio;
    Accion accion;
    Equipo equipo;
    Celda celda;

    public double getVida(){
        return vida;
    }

    public int getPrecio(){
        return precio;
    }

    public void interactuar(Unidad unidad, int distancia, double incremento) throws RangoMuyLejano, RangoMuyCercano {
        accion.interactuar(unidad, distancia,incremento);
    }

    public void recibirCuracion(double vidaCurada){
        vida += vidaCurada;
    }

    public void recibirDanio(double danio){
        if(this.estaMuerta()){
            try {
                celda.quitarUnidad();
            } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            }
        }
        vida -= danio;
    }

    public boolean estaMuerta(){
        if(vida <= 0){ return true;}
        return false;
    }

    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }

    public Equipo getEquipo (){ return this.equipo;}

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public Equipo verEquipo() {
        return this.equipo;
    }

    public List<Unidad> verUnidadesAdyacentes(){
        return celda.verUnidadesAdyacentes();
    }

   public abstract String getStringAccion();
}
