package vista;

import controladores.BotonCeldaHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.Unidad;

public class VistaCelda extends ToggleButton {

    public Celda celda;
    private VBox unidades;

    public VistaCelda(Celda celda, int equipo){
        super();

        this.celda = celda;

        try {
            VistaUnidadTablero vista = VistaUnidad.imagenDeUnidad(celda.verUnidad());
            //vista.setTamanio(40, 30);
           /* BackgroundImage bImage = new BackgroundImage(vista.imagen.getImage(), BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(50, 40, false, false, true, true));*/
            //Background fondo = new Background(bImage);
            this.setGraphic(vista);
            //this.setBackground(fondo);
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
        }
        //this.setText(String.valueOf(equipo));
        this.setPrefSize(40, 50);
        this.setMaxSize(40, 50);

        if(equipo == 2) {
            this.setStyle("-fx-background-color: #6c6eb3");
        }
        else
            this.setStyle("-fx-background-color: #b35051");
    }

    public void setHandler(EventHandler<ActionEvent> eventHandler){
        this.setOnAction(eventHandler);
    }

    public void unidadesAMostrar(VBox unidadesIzquierda) {
        this.unidades = unidadesIzquierda;
    }
}
