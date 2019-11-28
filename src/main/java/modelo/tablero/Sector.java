package modelo.tablero;

import modelo.ErroresYExcepciones.CeldaNoEstaEnMiSector;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.CeldaYaTieneUnidad;
import modelo.equipo.Equipo;
import modelo.unidad.Unidad;
import modelo.celda.Celda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sector {
    private List<Celda> celdas;
    private Equipo equipoDelSector;

    public Sector(){
       this.celdas = new ArrayList<Celda>();
    }

    public void agregar(Celda celda){
        this.celdas.add(celda);
    }

    public void colocarUnidad(Celda miCelda, Unidad unaUnidad) throws CeldaNoEstaEnMiSector, CeldaYaTieneUnidad {

        Celda celdaEncontrada = this.encontrarCelda(miCelda);
        celdaEncontrada.colocarUnidad(unaUnidad);
        unaUnidad.setCelda(miCelda);

    }

    public Celda encontrarCelda(Celda celdaAEncontrar) throws CeldaNoEstaEnMiSector {

        Iterator iter = this.celdas.iterator();
        Celda celdaActual = null;
        while(iter.hasNext()){

            celdaActual = (Celda) iter.next();

            if(celdaAEncontrar.medirDistacia(celdaActual) == 0) {
                return(celdaActual);
            }

        }

        throw new CeldaNoEstaEnMiSector();
    }

    public void setEquipo(Equipo equipo) {
        this.equipoDelSector = equipo;
    }

    public double definirIncremento(Celda celdaDestino) throws CeldaNoTieneUnidad {
        if(celdaDestino.verUnidad().verEquipo() != this.equipoDelSector) return 1.05;
        return 1;
    }
}
