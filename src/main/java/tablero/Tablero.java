package tablero;

import celda.Celda;

import java.util.ArrayList;
import java.util.List;


public class Tablero {

    private List <Celda> celdas;

    public Tablero(int largo, int alto) {
        celdas = new ArrayList<Celda>();
        for (int i = 0; i < largo; i++ ){
            for ( int j = 0; j < alto; j++ ){
                celdas.add(new Celda(i,j));
            }
        }

    }
}
