package vista;

import controladores.BotonCeldaHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.celda.Celda;
import modelo.celda.Posicion;
import modelo.equipo.Equipo;
import modelo.tablero.Tablero;
import modelo.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class VistaTablero extends GridPane {

    private List<VistaCelda> vistaCeldas;
    public VBox unidadesIzquierda;

    public VistaTablero(Equipo equipo1, Equipo equipo2, Tablero tablero, VBox unidadesIzquierda) throws NoSeEncontroLaCelda {
        super();

        this.vistaCeldas = new ArrayList<>();

        this.setHeight(1280);
        this.setWidth(720);
        this.setVgap(5);
        this.setHgap(5);


        int equipo;
        for (int fila = 1; fila <= 20; fila++) {
            for (int col = 1; col <= 20; col++) {
                if(col > 10){
                    equipo = 2;
                }else{
                    equipo = 1;
                }
                VistaCelda celda = new VistaCelda(tablero.buscarCeldaConPosicion(new Posicion(fila, col)), equipo);
                celda.unidadesAMostrar(unidadesIzquierda);
                this.add(celda, fila, col);
                this.vistaCeldas.add(celda);
            }
        }
    }

    public void botones() {
        for (VistaCelda vistaCelda : this.vistaCeldas) {
            vistaCelda.setHandler(new BotonCeldaHandler(vistaCelda.celda));
        }
    }


}
