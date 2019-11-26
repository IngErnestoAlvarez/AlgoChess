package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.CeldaNoEstaEnElTablero;
import modelo.ErroresYExcepciones.CeldaYaTieneUnidad;
import modelo.ErroresYExcepciones.TableroSectorInvalido;
import modelo.tablero.Tablero;
import vista.MainApp;
import vista.VistaCelda;
import vista.VistaTablero;
import vista.VistaUnidadTablero;

public class ClickearCeldaColocarUnidad implements EventHandler<ActionEvent> {
    private VBox seleccionados;
    private Tablero tablero;
    private VistaCelda vistaCelda;
    private VistaTablero vistaTablero;

    public ClickearCeldaColocarUnidad(VBox seleccionados, Tablero tablero, VistaCelda vistaCelda, VistaTablero vistaTablero){
        this.seleccionados = seleccionados;
        this.tablero = tablero;
        this.vistaCelda = vistaCelda;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaUnidadTablero vistaUnidad = (VistaUnidadTablero) seleccionados.getChildren().get(0);
        try {
            tablero.colocarUnidad(vistaUnidad.getUnidad(), vistaCelda.celda.verPosicion());
            seleccionados.getChildren().remove(vistaUnidad);
        } catch (TableroSectorInvalido tableroSectorInvalido) {
        } catch (CeldaNoEstaEnElTablero celdaNoEstaEnElTablero) {
        } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
        }
        try {
            vistaTablero.llenarCeldas();
            vistaTablero.colocarHandlers(seleccionados);
        } catch (Exception e) {
        }
    }
}
