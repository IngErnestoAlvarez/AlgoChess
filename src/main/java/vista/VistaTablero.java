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

    public VistaTablero(Equipo equipo1, Equipo equipo2, Tablero tablero) throws NoSeEncontroLaCelda {
        super();

        this.vistaCeldas = new ArrayList<>();

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
                VistaCelda celda = new VistaCelda(tablero.buscarCeldaConPosicion(new Posicion(i, j)), equipo, this);
                this.add(celda, i, j);
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
