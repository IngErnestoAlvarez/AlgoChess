package tablero;

import ErroresYExcepciones.CeldaYaTieneUnidad;
import ErroresYExcepciones.TableroSectorInvalido;
import Unidad.Unidad;
import celda.Celda;
import equipo.Equipo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Tablero {

    private List <Celda> celdas;
    private Equipo equipoDeAbajo;
    private Equipo equipoDeArriba;
    private List <Celda> sectorDeArriba;
    private List <Celda> sectorDeAbajo;
    private boolean quienPone; //true abajo, false arriba

    public Tablero(int largo, int alto, Equipo equipoDeAbajo, Equipo equipoDeArriba) {
        this.equipoDeAbajo = equipoDeAbajo;
        this.equipoDeArriba = equipoDeArriba;
        this.sectorDeAbajo = new ArrayList<Celda>();
        this.sectorDeArriba = new ArrayList<Celda>();
        this.celdas = new ArrayList<Celda>();
        for (int i = 0; i < largo; i++ ){
            for ( int j = 0; j < alto; j++ ){
                Celda celda = new Celda(i,j);
                this.celdas.add(celda);
                if( i > 10 ) this.sectorDeArriba.add(celda);
                else this.sectorDeAbajo.add(celda);
            }
        }
    }

    public void colocarUnidad(Unidad unaUnidad,int posicionHorizontal,int  posicionVertical) throws TableroSectorInvalido {
        Celda miCelda = this.BuscarCeldaConPosicion(posicionHorizontal, posicionVertical);

        if(this.sectorDeAbajo.contains(miCelda) && this.quienPone) {
            try {
                miCelda.colocarUnidad(unaUnidad);
            } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
                celdaYaTieneUnidad.printStackTrace();
            }
        }

        if(this.sectorDeArriba.contains(miCelda) && !this.quienPone){
            try {
                miCelda.colocarUnidad(unaUnidad);
            } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
                celdaYaTieneUnidad.printStackTrace();
            }
        }

        throw new TableroSectorInvalido();
    }

    private Celda BuscarCeldaConPosicion(int posicionHorizontal, int posicionVertical) {
        Iterator iter = this.celdas.iterator();
        Celda celdaQueQuieroEncontrar = new Celda(posicionHorizontal,posicionVertical);
        Celda celdaActual = null;
        while(iter.hasNext()){
            celdaActual = (Celda) iter.next();
            if(celdaQueQuieroEncontrar.calcularDistanciaCon(celdaActual) == 0) return celdaActual;
        }
        return null;
    }
}
