package vista;

import controladores.BotonCeldaHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.Unidad;

public class VistaCelda extends Button {

    public Celda celda;
    private VBox unidades;

    public VistaCelda(Celda celda, int equipo){
        super();

        this.celda = celda;
        /*ImageView imagen = new ImageView();
        try {
            String url = String.format("./resources/imagenes/%s.png", celda.verUnidad().getClass().getSimpleName());
            Image unidad = new Image(url);
        }catch(CeldaNoTieneUnidad e){}

         */

        this.setText(String.valueOf(equipo));
        this.setPrefHeight(50);
        this.setPrefWidth(40);

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
