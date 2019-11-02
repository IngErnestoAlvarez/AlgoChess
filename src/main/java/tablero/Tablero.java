package tablero;

import ErroresYExcepciones.CeldaYaTieneUnidad;
import ErroresYExcepciones.TableroSectorInvalido;
import Unidad.Unidad;
import celda.Celda;
import equipo.Equipo;

import java.util.ArrayList;
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

    public void colocarUnidad(Unidad unaUnidad, Celda unaCelda) throws TableroSectorInvalido {
        if(this.quienPone){
            if(this.sectorDeAbajo.contains(unaCelda)){
                try {
                    unaCelda.colocarUnidad(unaUnidad); // capaz hace falta un metodo que busque unidades en el tablero ya que la celda que se pasa por parametro DEBE SER una que esta dentro del tablero
                } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
                    celdaYaTieneUnidad.printStackTrace();
                }
            } else {
                throw new TableroSectorInvalido();
            }
        } else {
            if(this.sectorDeArriba.contains(unaCelda)){
                try {
                    unaCelda.colocarUnidad(unaUnidad);
                } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
                    celdaYaTieneUnidad.printStackTrace();
                }
            } else {
                throw new TableroSectorInvalido();
            }
        }
    }
}
