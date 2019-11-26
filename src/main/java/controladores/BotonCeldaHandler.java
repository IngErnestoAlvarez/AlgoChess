package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.celda.Celda;
import modelo.unidad.Soldado;
import vista.VistaUnidad;

public class BotonCeldaHandler implements EventHandler<ActionEvent> {

    private Celda celda;
    private VBox unidad;

    public BotonCeldaHandler(Celda celda){
        this.celda = celda;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            this.unidad = new VBox(new VistaUnidad(new Soldado()));
            celda.verUnidad();
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            celdaNoTieneUnidad.printStackTrace();
        }
    }
}
