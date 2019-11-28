package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.celda.Celda;
import modelo.unidad.Soldado;
import modelo.unidad.Unidad;
import vista.VistaUnidad;
import vista.VistaUnidadInfo;

public class BotonCeldaHandler implements EventHandler<ActionEvent> {

    private Celda celda;
    private VBox unidad;


    public BotonCeldaHandler(Celda celda, VBox unidadAMostrar){
        this.celda = celda;
        this.unidad = unidadAMostrar;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Unidad unidadCelda = celda.verUnidad();
            this.unidad.getChildren().clear();
            this.unidad.getChildren().add(new VistaUnidadInfo(unidadCelda));
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
        }
    }
}
