package vista;

import controladores.BotonCeldaHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.celda.Celda;
import modelo.equipo.Equipo;
import modelo.unidad.Unidad;

public class VistaCelda extends Button {

    public Celda celda;
    private VistaTablero tablero;

    public VistaCelda(Celda celda, int equipo, VistaTablero tablero){
        super();

        this.celda = celda;
        this.tablero = tablero;

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

}
