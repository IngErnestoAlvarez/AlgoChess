package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.celda.Celda;

public class VistaCelda extends ToggleButton {

    public Celda celda;
    private VBox unidades;
    private int height = 40;
    private int width = 50;

    public VistaCelda(Celda celda, int equipo){
        super();

        this.celda = celda;

        try {
            VistaUnidadTablero vista = VistaUnidad.imagenDeUnidad(celda.verUnidad());
            BackgroundImage bImage = new BackgroundImage(vista.imagen.getImage(), BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(50, 40, false, false, true, false));
            Background fondo = new Background(bImage);
            this.setBackground(fondo);
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {

            if(equipo == 2) {
                this.setStyle("-fx-background-color: #6c6eb3");
            }
            else
                this.setStyle("-fx-background-color: #b35051");

        }
        //this.setText(String.valueOf(equipo));
        this.setPrefSize(width, height);
        this.setMaxSize(width, height);


    }

    public void setHandler(EventHandler<ActionEvent> eventHandler){
        this.setOnAction(eventHandler);
    }

    public void unidadesAMostrar(VBox unidadesIzquierda) {
        this.unidades = unidadesIzquierda;
    }
}
