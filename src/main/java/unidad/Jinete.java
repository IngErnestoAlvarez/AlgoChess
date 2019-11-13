package unidad;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import celda.Celda;
import equipo.Equipo;
import unidad.estadosJinete.*;

import java.util.List;

public class Jinete extends Unidad {

    private EstadoJinete estadoJineteAtaque;

    private static final int precioJinete = 3;
    private static final int vidaJinete = 100;

    public Jinete(){
        precio = precioJinete;
        vida = vidaJinete;
        estadoJineteAtaque = new EstadoJineteAtaqueCercano();
    }

    public Jinete(Celda celda, Equipo equipo){
        precio = precioJinete;
        vida = vidaJinete;
        this.celda = celda;
        this.equipo = equipo;
    }

    public void usaAtaqueMedio(){
        estadoJineteAtaque = new EstadoJineteAtaqueMedio();
    }

    public void usaAtaqueCorto(){
        estadoJineteAtaque = new EstadoJineteAtaqueCercano();
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {
        if(this.tieneUnidadesEnemigasCerca()){ this.usaAtaqueCorto();}
        else{this.usaAtaqueMedio();}
        estadoJineteAtaque.atacar(unidad, distancia);
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

