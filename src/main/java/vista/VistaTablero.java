package vista;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.celda.Posicion;
import modelo.equipo.Equipo;
import modelo.tablero.Tablero;

public class VistaTablero extends GridPane {

    public VistaTablero(Equipo equipo1, Equipo equipo2) throws NoSeEncontroLaCelda {
        super();

        Tablero tablero = new Tablero(20, 20, equipo1, equipo2);

        this.setHeight(1280);
        this.setWidth(720);
        this.setVgap(5);
        this.setHgap(5);


        int equipo;
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if(j > 10){
                    equipo = 2;
                }else {
                    equipo = 1;
                }
                this.add(new VistaCelda(tablero.buscarCeldaConPosicion(new Posicion(i, j)), equipo), i, j);
            }
        }
    }
}
