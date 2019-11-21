package modelo.unidad;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.accion.AtaqueCercano;
import modelo.unidad.accion.AtaqueMedio;

import java.util.List;

public class Jinete extends Unidad {


    private static final int precioJinete = 3;
    private static final int vidaJinete = 100;

    public Jinete(){
        precio = precioJinete;
        vida = vidaJinete;
    }

    public Jinete(Celda celda, Equipo equipo){
        precio = precioJinete;
        vida = vidaJinete;
        this.celda = celda;
        this.equipo = equipo;
    }

    public void usaAtaqueMedio(){
        accion = new AtaqueMedio(15);
    }

    public void usaAtaqueCorto(){
        accion = new AtaqueCercano(5);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {
        if(this.tieneUnidadesEnemigasCerca()){ this.usaAtaqueCorto();}
        else{this.usaAtaqueMedio();}
        accion.interactuar(unidad, distancia);
    }

    private boolean tieneUnidadesEnemigasCerca(){
        List<Unidad> listaDeUnidades =  this.celda.verUnidadesAdyacentes();
        if(listaDeUnidades.isEmpty()){ return false;}
        else{
            for(Unidad unidad : this.celda.verUnidadesAdyacentes()){
                if(unidad.verEquipo() != this.equipo){
                    return true;
                }
            }
        }
        return false;
    }
}

