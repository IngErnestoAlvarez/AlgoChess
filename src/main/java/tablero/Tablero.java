package tablero;

import celda.Celda;
import equipo.Equipo;

import java.util.ArrayList;
import java.util.List;


public class Tablero {

    private List <Celda> celdas;
    private Equipo equipoDeAbajo;
    private Equipo equipoDeArriba;

    public Tablero(int largo, int alto, Equipo equipoDeAbajo, Equipo equipoDeArriba) {
        this.equipoDeAbajo = equipoDeAbajo;
        this.equipoDeArriba = equipoDeArriba;
        this.celdas = new ArrayList<Celda>();
        for (int i = 0; i < largo; i++ ){
            for ( int j = 0; j < alto; j++ ){
                this.celdas.add(new Celda(i,j));
            }
        }
    }
}
